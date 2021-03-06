package graphlang;

import graphlang.node.*;
import graphlang.analysis.*;

import java.awt.geom.Point2D;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

// todo: if(!up) is problematic, since it stops the first run but it maybe valid.
//  Have to ensure that paintComponent only runs when necessary
// todo: after erase we repaint and get out of the callStack loop, so nothing works after erase

// run XLaunch, then type in Ubuntu:
// echo "export DISPLAY=localhost:0.0" >> ~/.bashrc
//  . ~/.bashrc

// To run code:
// java -jar lib/sablecc.jar grammar.txt
// javac graphlang/Compiler.java
// java graphlang.Compiler input.txt

// repaint called multiple times: https://stackoverflow.com/questions/34520852/why-is-the-paintcomponent-method-called-twice#:~:text=answer%20was%20accepted%E2%80%A6-,Why%20is%20the%20paintComponent%20method%20called%20twice%3F,end%20that%20cannot%20be%20achieved.
// https://seanthegeek.net/234/graphical-linux-applications-bash-ubuntu-windows/
// https://kodejava.org/how-do-i-draw-a-generalpath-in-java-2d/
// https://stackoverflow.com/questions/19386951/how-to-draw-a-circle-with-given-x-and-y-coordinates-as-the-middle-spot-of-the-ci
// http://www.java2s.com/Tutorial/Java/0261__2D-Graphics/Catalog0261__2D-Graphics.htm


public class SemanticAnalyzer extends DepthFirstAdapter {

    static class Coordinate{
        int x,y;

        Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public double distance(Coordinate c2){
            return Math.sqrt((c2.getX()-this.getX())*(c2.getX()-this.getX()) + (c2.getY()-this.getY())*(c2.getY()-this.getY()));
        }
    }

    enum Direction{
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    enum Shape{
        STRAIGHT,
        CURVED
    }

    enum Colors{
        RED(0, Color.RED),
        BLUE(1, Color.BLUE),
        GREEN(2, Color.GREEN),
	    ORANGE(3,Color.ORANGE),
        PINK(4,Color.PINK),
        BLACK(5, Color.BLACK),
        YELLOW(6,Color.YELLOW);

        private int num;
        private Color col;

        public int getNum()
        {
            return this.num;
        }

        public Color getCol()
        {
            return this.col;
        }

        Colors(int num, Color col)
        {
            this.num = num;
            this.col = col;
        }
    }

    private static int curX = 0;
    private static int curY = 0;
    public static int frameX = 0;
    public static int frameY = 0;
    public static int init_size = 1;
    public static JFrame window;

    public static Colors curColor = Colors.RED;
	public static boolean up = false;
	private static int calls = 0;
	public static boolean popupEnabled = true;

    static ArrayList<ArrayList<Coordinate>> points = new ArrayList<>(); // Colors, Coordinates
    static ArrayList<String> callStack = new ArrayList<>();
    static Graphics2D g2;

    public void outAFillrColorize(AFillrColorize node){
        callStack.add(node.toString());
    }

    public void outAConnectcolorConnectcolor(AConnectcolorConnectcolor node){
		callStack.add(node.toString());	
    }
    public void outAMarkpoint(AMarkpoint node){
		callStack.add(node.toString());	
    }

    public void outAMoveMove(AMoveMove node){
		callStack.add(node.toString());
    }
	
	public void outAChooseChoosecolor(AChooseChoosecolor node){
		callStack.add(node.toString());
	}
    public void outAMakecircleCircle(AMakecircleCircle node){
        callStack.add(node.toString());
    }
	public void outAMakesquareSquare(AMakesquareSquare node){
		callStack.add(node.toString());
	}
    public void outAMaketriangleTriangle(AMaketriangleTriangle node){
        callStack.add(node.toString());
    }
    public void outAMakerectangleRectangle(AMakerectangleRectangle node){
        callStack.add(node.toString());
    }
    public void outAMakerhombusRhombus(AMakerhombusRhombus node){
        callStack.add(node.toString());
    }

	public void outAErasecolorErase(AErasecolorErase node){
		callStack.add(node.toString());
	}

    public void outADefineDefinegrid(ADefineDefinegrid node) {
        initPoints();

        window = new JFrame();
        JComponent jComponent = new JComponent() {

            @Override
            protected void paintComponent(Graphics g) {

                g2 = (Graphics2D) g;
                // Vertical / Horizontal axis
                g2.drawLine(frameX / 2, 0, frameX / 2, frameY);
                g2.drawLine(0, frameY / 2, frameX, frameY / 2);


                Font currentFont = g2.getFont();
                Font newFont = currentFont.deriveFont(currentFont.getSize() * 0.7F);
                g2.setFont(newFont);

                for (int i = 1; i < 4; i++) {
                    g2.drawLine(frameX / 2 - 5, frameY * i / 8, frameX / 2 + 5, frameY * i / 8);
                    g2.drawLine(frameX / 2 - 5, frameY - (frameY * i / 8), frameX / 2 + 5, frameY - (frameY * i / 8));
                    g2.drawString(Integer.toString(frameY * i / 8 / 10), frameX / 2 + 10, frameY / 2 + frameY * i / 8 + 5);
                    g2.drawString(Integer.toString(frameY * i / 8 / 10), frameX / 2 + 10, frameY / 2 - frameY * i / 8 + 5);
                }

                for (int i = 1; i < 4; i++) {
                    g2.drawLine(frameX - frameX * i / 8, frameY / 2 - 5, frameX - frameX * i / 8, frameY / 2 + 5);
                    g2.drawLine(frameX * i / 8, frameY / 2 - 5, frameX * i / 8, frameY / 2 + 5);
                    g2.drawString(Integer.toString((frameX * i / 8) / 10), frameX / 2 - frameX * i / 8 - 7, frameY / 2 + 18);
                    g2.drawString(Integer.toString((frameX * i / 8) / 10), frameX / 2 + frameX * i / 8 - 7, frameY / 2 + 18);
                }
//
//                g2.drawString("X", 5, frameY / 2+12);
//                g2.drawString("Y", frameX/2+10, 15);


                calls++;
				
				/*if(calls % 2 == 0){
					update();
				}*/
                // Start from the center of the graph
                curX = frameX / 2;
                curY = frameY / 2;
                update();


            }

            public void update() {

                g2.setColor(curColor.getCol());

                for (int i = 0; i < callStack.size(); i++) {
                    String cur = callStack.get(i);
                    StringTokenizer st = new StringTokenizer(cur, " ");
                    String current_token = st.nextToken().toUpperCase();


                    switch (current_token) {
                        case "CONNECT": {
                            String col = st.nextToken();
                            String type = st.nextToken();
                            if (type.toUpperCase().equals("CURVED")) {
                                ConnectCurved(col);
                            } else {
                                ConnectStraight(col);
                            }
                            break;
                        }
                        case "MARK": {
                            MarkPoint();
                            break;
                        }
                        case "FILL": {
                            System.out.println("Token count " + st.countTokens());

                            switch (st.countTokens()) {
                                case 1: {
                                    Fill(st.nextToken());
                                    break;
                                }
                                case 2: {
                                    Fill(st.nextToken(), st.nextToken());
                                    break;
                                }
                                case 3: {
                                    Fill(st.nextToken(), st.nextToken(), st.nextToken(), new ArrayList<>());
                                    break;
                                }
                                default: {
                                    List<String> list_colors = new ArrayList<>();

                                    while (st.hasMoreTokens()) {
                                        list_colors.add(st.nextToken());
                                    }
                                    Fill(list_colors.get(0), list_colors.get(1), list_colors.get(2), list_colors.subList(1, list_colors.size()));
                                    break;
                                }
                            }
                            break;
                        }
                        case "LEFT":
                        case "DOWN":
                        case "UP":
                        case "RIGHT": {
                            Move(current_token, st.nextToken());
                            break;
                        }
                        case "CHOOSE": {
                            ChooseColor(st.nextToken());
                            break;
                        }
                        case "CIRCLE": {
                            if (st.countTokens() == 1) {
                                DrawCircle(st.nextToken(), curColor.toString());
                                break;
                            } else if (st.countTokens() == 2) {
                                DrawCircle(st.nextToken(), st.nextToken());
                                break;
                            } else {
                                DrawCircle(st.nextToken(), st.nextToken(), st.nextToken());
                            }
                            g2.setColor(curColor.getCol());
                            break;
                        }
                        case "SQUARE": {
                            System.out.println("Sq"+st.countTokens());
                            if (st.countTokens() == 1) {
                                DrawSquare(st.nextToken(), curColor.toString());
                                break;
                            } else if (st.countTokens() == 2) {
                                DrawSquare(st.nextToken(), st.nextToken());
                                break;
                            } else {
                                DrawSquare(st.nextToken(), st.nextToken(), st.nextToken());
                            }
                            g2.setColor(curColor.getCol());
                            break;
                        }
                        case "TRIANGLE": {
                            if (st.countTokens() == 1) {
                                DrawTriangle(st.nextToken(), curColor.toString());
                                break;
                            } else if (st.countTokens() == 2) {
                                DrawTriangle(st.nextToken(), st.nextToken());
                                break;
                            } else if (st.countTokens() == 3) {
                                DrawTriangle(st.nextToken(), st.nextToken(), st.nextToken());
                                break;
                            } else {
                                DrawTriangle(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
                            }
                            g2.setColor(curColor.getCol());
                            break;
                        }
                        case "RECTANGLE": {
                            if (st.countTokens() == 2) {
                                DrawRectangle(st.nextToken(), st.nextToken(), curColor.toString());
                                break;
                            } else if (st.countTokens() == 3) {
                                DrawRectangle(st.nextToken(), st.nextToken(), st.nextToken());
                                break;
                            } else {
                                DrawRectangle(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
                            }
                            g2.setColor(curColor.getCol());
                            break;
                        }
                        case "RHOMBUS": {
                            if (st.countTokens() == 1) {
                                DrawRhombus(st.nextToken(), curColor.toString());
                                break;
                            } else if (st.countTokens() == 2) {
                                DrawRhombus(st.nextToken(), st.nextToken());
                                break;
                            } else {
                                DrawRhombus(st.nextToken(), st.nextToken(), st.nextToken());
                            }
                            g2.setColor(curColor.getCol());
                            break;
                        }
                        case "ERASE": {
                            EraseShape(st.nextToken());
                            break;
                        }

                    }
                }
                // Show current position
                g2.setColor(Color.BLACK);
                g2.setStroke(new BasicStroke(8.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
                g2.drawLine(curX, curY, curX, curY);
                g2.setColor(curColor.getCol());
                g2.setStroke(new BasicStroke(6.0f));

                //callStack = new ArrayList<>();
            }

            public void ChooseColor(String color) {
                System.out.println("co " + color);
                curColor = Colors.valueOf(color.toUpperCase());
                g2.setColor(curColor.getCol());
            }

            public boolean isValidMovement(int curXY, int z, int frameXY, String operation, String direction) {
                if (operation.equals("-")) {
                    if (curXY - z < 0) {
                        if (popupEnabled) {
                            JOptionPane.showMessageDialog(null,
                                    direction + " command goes beyond the frame size",
                                    direction + " error",
                                    JOptionPane.WARNING_MESSAGE);
                            popupEnabled = false;
                        }

                        return false;

                    }
                } else {
                    if (curXY + z > frameXY) {
                        if (popupEnabled) {
                            JOptionPane.showMessageDialog(null,
                                    direction + " command goes beyond the frame size",
                                    direction + " error",
                                    JOptionPane.WARNING_MESSAGE);
                            popupEnabled = false;
                        }

                        return false;

                    }
                }
                return true;
            }

            public void Move(String dir, String s) {
                int z = Integer.parseInt(s) * init_size;

                int newX = curX;
                int newY = curY;

                switch (dir.toUpperCase()) {
                    case "UP": {
                        if (isValidMovement(curY, z, 0, "-", "UP")) {
                            newY = curY - z;
                        }
                        break;
                    }
                    case "DOWN": {
                        if (isValidMovement(curY, z, frameY, "+", "DOWN")) {
                            newY = curY + z;
                        }
                        break;
                    }
                    case "LEFT": {
                        if (isValidMovement(curX, z, 0, "-", "LEFT")) {
                            newX = curX - z;
                        }
                        break;
                    }
                    case "RIGHT": {
                        if (isValidMovement(curX, z, frameX, "+", "RIGHT")) {
                            newX = curX + z;
                        }
                        break;
                    }
                }
                if (newX > frameX || newY > frameY || newX < 0 || newY < 0) {
                    System.out.println("Index out of frame");
                } else {
                    curX = newX;
                    curY = newY;
                }
            }

            public void MarkPoint() {
                points.get(curColor.getNum()).add(new Coordinate(curX, curY));
            }

            public void MarkPoint(int x, int y) {
                points.get(curColor.getNum()).add(new Coordinate(x, y));
            }

            public void MarkPoint(Colors color, int x, int y) {
                points.get(color.getNum()).add(new Coordinate(x, y));
            }

            public void Fill(String color_path) {
                Fill(color_path, curColor.toString());

            }

            public void Fill(String color_path, String color_fill) {
                Fill(color_path, color_fill, color_fill, new ArrayList<>());
            }

            public void Fill(String color_path, String color_fill, String color_gradient, List<String> all_commands) {
                System.out.println("outputted color is " + color_path);
                System.out.println("outputted color is 2 " + color_fill);
                System.out.println("outputted color is 3 " + color_fill);
                Colors color_pa = Colors.valueOf(color_path.toUpperCase());
                Colors color_fi = Colors.valueOf(color_fill.toUpperCase());
                Colors color_gr = Colors.valueOf(color_gradient.toUpperCase());
                g2.setColor(color_pa.getCol());
                g2.setPaint(color_fi.getCol());
                if (points.get(color_pa.getNum()).size() != 0) {
                    //g2.setColor(curColor);
                    g2.setStroke(new BasicStroke(2.0f));
                    GeneralPath path = new GeneralPath(GeneralPath.WIND_NON_ZERO);

                    Coordinate first_point = points.get(color_pa.getNum()).get(0);

                    Coordinate largest_point1 = points.get(color_pa.getNum()).get(0);
                    Coordinate largest_point2 = points.get(color_pa.getNum()).get(0);
                    double distance_points = 0;

                    path.moveTo(first_point.getX(), first_point.getY());


                    for (int i = 1, j = 0; i < points.get(color_pa.getNum()).size(); i++) {
                        Coordinate current_point = points.get(color_pa.getNum()).get(i);
                        if (j == 0) {
                            distance_points = first_point.distance(current_point);
                            largest_point1 = first_point;
                            largest_point2 = current_point;
                            j = 1;
                        }
//                        System.out.printf("Fill %d %d\n", points.get(color_pa.getNum()).get(i).getX(),points.get(color_pa.getNum()).get(i).getY());
                        path.lineTo(current_point.getX(), current_point.getY());

                        Coordinate buffer_point = new Coordinate((int) path.getCurrentPoint().getX(), (int) path.getCurrentPoint().getY());
                        if (buffer_point.distance(current_point) > distance_points) {
                            distance_points = buffer_point.distance(current_point);
                            largest_point1 = buffer_point;
                            largest_point2 = current_point;
                        }
                    }

                    path.closePath();
                    if (!(color_fi == color_gr)) {
                        System.out.println("GRADIENT");
                        System.out.printf("%d %d\n", largest_point1.getX(), largest_point1.getY());
                        System.out.printf("%d %d\n", largest_point2.getX(), largest_point2.getY());
                        System.out.println(distance_points);
                        if (all_commands.isEmpty()) {
                            g2.setPaint(new GradientPaint(largest_point1.getX(), largest_point1.getY(), color_fi.getCol(), largest_point2.getX(), largest_point2.getY(), color_gr.getCol()));
                        } else {
                            IntStream intStream = IntStream.range(0, all_commands.size());
                            int[] values_range = intStream.toArray();
                            System.out.println("the range " + Arrays.toString(values_range));
                            float[] updated_range = new float[values_range.length];
                            for (int i = 0; i < values_range.length; i++) {
                                updated_range[i] = (float) values_range[i] / (all_commands.size());
                            }
                            System.out.println("the updated range " + Arrays.toString(values_range));
                            Color[] colors = new Color[updated_range.length];
                            for (int i = 0; i < colors.length; i++) {
                                colors[i] = Colors.valueOf(all_commands.get(i).toUpperCase()).getCol();
                            }
                            System.out.println("the colors used " + Arrays.toString(colors));
                            g2.setPaint(new RadialGradientPaint(new Point2D.Float((float) largest_point1.getX(), (float) largest_point1.getY()), (float) distance_points, updated_range, colors));
                        }

                    }
                    g2.fill(path);

                }
                g2.setColor(curColor.getCol());
                g2.setPaint(curColor.getCol());
            }

            public void ConnectStraight(String str) {
                Colors color = Colors.valueOf(str.toUpperCase());
                g2.setColor(color.getCol());
//                g2.setPaint(new GradientPaint(0,0,Color.RED,100, 0,Color.WHITE));
                if (points.get(color.getNum()).size() != 0) {
                    //g2.setColor(curColor);
                    g2.setStroke(new BasicStroke(2.0f));
                    GeneralPath path = new GeneralPath(GeneralPath.WIND_NON_ZERO);

                    path.moveTo(points.get(color.getNum()).get(0).getX(), points.get(color.getNum()).get(0).getY());
                    Coordinate cord1, cord2, cord3;

                    for (int i = 2; i < points.get(color.getNum()).size(); i++) {
                        System.out.printf("Connect %d %d\n", points.get(color.getNum()).get(i).getX(), points.get(color.getNum()).get(i).getY());
//                        cord1 = points.get(color.getNum()).get(i - 2);
//                        cord2 = points.get(color.getNum()).get(i - 1);
//                        cord3 = points.get(color.getNum()).get(i);

                        path.lineTo(points.get(color.getNum()).get(i).getX(), points.get(color.getNum()).get(i).getY());
//                        path.curveTo((float) cord2.getX(), (float) cord2.getY(), (float) cord2.getX(), (float) cord2.getY(), (float) cord3.getX(), (float) cord3.getY());

                    }
                    path.closePath();
                    g2.draw(path);

                }
                System.out.println();
                g2.setColor(curColor.getCol());
            }

            public void ConnectCurved(String color_path) {
                Colors color = Colors.valueOf(color_path.toUpperCase());
                g2.setStroke(new BasicStroke(2.0f));
                g2.setColor(color.getCol());

                QuadCurve2D q = new QuadCurve2D.Float();

                Coordinate cord1, cord2, cord3;

                int len = points.get(color.getNum()).size();
                if (len != 0) {
                    cord1 = points.get(color.getNum()).get(0);
                    if (len == 1) {
                        g2.drawLine(cord1.getX(), cord1.getY(), cord1.getX(), cord1.getY());
                    } else {
                        for (int i = 1; i < points.get(color.getNum()).size(); i++) {
                            if (i % 2 == 0) {
                                cord2 = points.get(color.getNum()).get(i - 1);
                                cord3 = points.get(color.getNum()).get(i);
                                System.out.printf("Connect 1: %d %d\n", cord1.getX(), cord1.getY());
                                System.out.printf("Connect 2: %d %d\n", cord2.getX(), cord2.getY());
                                System.out.printf("Connect 3: %d %d\n", cord3.getX(), cord3.getY());
//                                int r = (int)Math.sqrt((cord2.getX()-cord1.getX())*(cord2.getX()-cord1.getX()) + (cord2.getY()-cord1.getY())*(cord2.getY()-cord1.getY()));
//                                int x = cord1.getX()-r;
//                                int y = cord1.getY()-r;
//                                int width = 2*r;
//                                int height = 2*r;
//                                int startAngle = (int) (180/Math.PI*Math.atan2((cord2.getY()-cord1.getY()), (cord2.getX()-cord1.getX())));
//                                int endAngle = (int) (180/Math.PI*Math.atan2((cord3.getY()-cord1.getY()), (cord3.getX()-cord1.getX())));
//                                g2.drawArc(x, y, width, height, startAngle, endAngle);
//                                q.setCurve(cord1.getX(), cord1.getY(), (float)(cord1.getX() + cord2.getX())/2+ 25, (float)(cord1.getY() + cord2.getY())/2, cord2.getX(), cord2.getY());
                                q.setCurve(cord1.getX(), cord1.getY(), cord2.getX(), cord2.getY(), cord3.getX(), cord3.getY());
                                g2.draw(q);
//                                break;


                                cord1 = cord3;
                            }
                            System.out.println();
                        }
                    }
                } else {
                    System.out.println("No points of this color");
                }

                g2.setColor(curColor.getCol());

            }

            public void DrawCircle(String di, String color) {
                DrawCircle(di, color, "");
            }

            public void DrawCircle(String di, String colr, String color_fill) {
                Colors color = Colors.valueOf(colr.toUpperCase());
                int diameter = Integer.parseInt(di) * init_size;
                int half_diameter = diameter / 2;
//               System.out.printf("values are %d %d %d %d %d\n", diameter, curY, curX, frameY, frameX);
                int max_diameter = half_diameter + (half_diameter / 100 * 20);
                if ((curY + max_diameter >= 0 && curY + max_diameter <= frameY) && (curX + max_diameter >= 0 && curX + max_diameter <= frameX)) {
                    Ellipse2D.Double circle = new Ellipse2D.Double(curX - half_diameter, curY - half_diameter, diameter, diameter);
                    g2.setColor(color.getCol());
                    g2.draw(circle);

                    if (!color_fill.isEmpty()) {
                        System.out.println("fill circle");
                        g2.setPaint(Colors.valueOf(color_fill.toUpperCase()).getCol());
                        g2.fill(circle);
                    }
                } else {
                    if (popupEnabled) {
                        JOptionPane.showMessageDialog(null,
                                "\"Circle\" is beyond the window boundaries ",
                                "RIGHT error",
                                JOptionPane.WARNING_MESSAGE);
                        popupEnabled = false;
                    }

                }
            }

            public void DrawSquare(String di, String color) {
                DrawSquare(di, color, "");
            }

            public void DrawSquare(String di, String colr, String color_fill) {
                Colors color = Colors.valueOf(colr.toUpperCase());
                int side_length = Integer.parseInt(di) * init_size;

                if ((curY + side_length <= frameY) && (curX + side_length <= frameX)) {
//                    MarkPoint(color,curX+half_side,curY+half_side);
//                    MarkPoint(color,curX+half_side,curY-half_side);
//                    MarkPoint(color,curX-half_side,curY+half_side);
//                    MarkPoint(color,curX-half_side,curY-half_side);
//                    ConnectStraight(color.toString());
                    g2.setColor(color.getCol());
                    g2.drawRect(curX, curY, side_length, side_length);
                    if (!color_fill.isEmpty()) {
                        g2.setPaint(Colors.valueOf(color_fill.toUpperCase()).getCol());
                        g2.fillRect(curX, curY, side_length, side_length);
                    }

                } else {
                    JOptionPane.showMessageDialog(null,
                            "\"Square\" is beyond the window boundaries ",
                            "RIGHT error",
                            JOptionPane.WARNING_MESSAGE);

                }
            }

            public boolean isInteger(String s, int radix) {
                Scanner sc = new Scanner(s.trim());
                if (!sc.hasNextInt(radix)) return false;
                // we know it starts with a valid int, now make sure
                // there's nothing left!
                sc.nextInt(radix);
                return !sc.hasNext();
            }

            public void DrawTriangle(String di, String color) {
                DrawTriangle(di, color, "");
            }

            public void DrawTriangle(String di, String color, String tritype) {
                DrawTriangle(di, color, tritype, "");
            }

            public void DrawTriangle(String di, String colr, String tritype, String color_fill) {
                Colors color = Colors.valueOf(colr.toUpperCase());
                tritype = tritype.toUpperCase();
                int side_length = Integer.parseInt(di) * init_size;

                if ((curY + 1.5 * side_length <= frameY) && (curX + side_length <= frameX)) {
                    g2.setColor(color.getCol());
                    if (tritype.equals("RI") || tritype.equals("RIGHT")) {
                        System.out.println("RIGHT");
                        g2.drawPolygon(new int[]{curX, curX, curX + side_length}, new int[]{curY, curY - side_length, curY}, 3);
                        if (!color_fill.isEmpty()) {
                            g2.setPaint(Colors.valueOf(color_fill.toUpperCase()).getCol());
                            g2.fillPolygon(new int[]{curX, curX, curX + side_length}, new int[]{curY, curY - side_length, curY}, 3);
                        }
                    } else if (tritype.equals("EQUI") || tritype.equals("EQUILATERAL")) {
                        g2.drawPolygon(new int[]{curX, curX + side_length / 2, curX + side_length}, new int[]{curY, curY - side_length, curY}, 3);
                        if (!color_fill.isEmpty()) {
                            g2.setPaint(Colors.valueOf(color_fill.toUpperCase()).getCol());
                            g2.fillPolygon(new int[]{curX, curX + side_length / 2, curX + side_length}, new int[]{curY, curY - side_length, curY}, 3);
                        }
                    } else if (tritype.equals("ISO") || tritype.equals("ISOCELES")) {
                        g2.drawPolygon(new int[]{curX, curX + side_length / 2, curX + side_length}, new int[]{curY, (int) (curY - 1.5 * side_length), curY}, 3);
                        if (!color_fill.isEmpty()) {
                            g2.setPaint(Colors.valueOf(color_fill.toUpperCase()).getCol());
                            g2.fillPolygon(new int[]{curX, curX + side_length / 2, curX + side_length}, new int[]{curY, (int) (curY - 1.5 * side_length), curY}, 3);
                        }
                    } else {
                        g2.drawPolygon(new int[]{curX, curX + ThreadLocalRandom.current().nextInt(0, side_length), curX + ThreadLocalRandom.current().nextInt(0, side_length)}, new int[]{curY, curY + ThreadLocalRandom.current().nextInt(0, side_length), curY + ThreadLocalRandom.current().nextInt(0, side_length)}, 3);
                        if (!color_fill.isEmpty()) {
                            g2.setPaint(Colors.valueOf(color_fill.toUpperCase()).getCol());
                            g2.fillPolygon(new int[]{curX, curX + ThreadLocalRandom.current().nextInt(0, side_length), curX + ThreadLocalRandom.current().nextInt(0, side_length)}, new int[]{curY, curY + ThreadLocalRandom.current().nextInt(0, side_length), curY + ThreadLocalRandom.current().nextInt(0, side_length)}, 3);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "\"Triangle\" is beyond the window boundaries ",
                            "RIGHT error",
                            JOptionPane.WARNING_MESSAGE);
                }
            }

            public void DrawRectangle(String height, String width, String color) {
                DrawRectangle(height, width, color, "");
            }

            public void DrawRectangle(String height, String width, String colr, String color_fill) {
                Colors color = Colors.valueOf(colr.toUpperCase());
                int H = Integer.parseInt(height) * init_size;
                int W = Integer.parseInt(width) * init_size;

                if ((curY + W <= frameY) && (curX + H <= frameX)) {
                    g2.setColor(color.getCol());
                    g2.drawRect(curX, curY, W, H);
                    if (!color_fill.isEmpty()) {
                        g2.setPaint(Colors.valueOf(color_fill.toUpperCase()).getCol());
                        g2.fillRect(curX, curY, W, H);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "\"Rectangle\" is beyond the window boundaries ",
                            "RIGHT error",
                            JOptionPane.WARNING_MESSAGE);
                }
            }


            public void DrawRhombus(String di, String col) {
                DrawRhombus(di, col, "");
            }


            public void DrawRhombus(String di, String colr, String color_fill) {
                Colors color;
                color = Colors.valueOf(colr.toUpperCase());
                int side = Integer.parseInt(di) * init_size;
                if ((curY + side <= frameY && curY - side >= 0) && (curX + side <= frameX)) {
                    g2.setColor(color.getCol());
                    g2.drawPolygon(new int[]{curX + (side / 2), curX + side, curX + (side / 2), curX}, new int[]{curY, curY + (side / 2), curY + side, curY + (side / 2) }, 4);
                    if (!color_fill.isEmpty()) {
                        g2.setPaint(Colors.valueOf(color_fill.toUpperCase()).getCol());
                        g2.fillPolygon(new int[]{curX + (side / 2), curX + side, curX + (side / 2), curX}, new int[]{curY, curY + (side / 2), curY + side, curY + (side / 2) }, 4);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "\"Rhombus\" is beyond the window boundaries ",
                            "RIGHT error",
                            JOptionPane.WARNING_MESSAGE);
                }
            }


            public void EraseShape(String col) {
                //Colors color = Colors.valueOf(col);
                g2.setColor(new Color(0, 0, 0, 0));
                g2.setComposite(AlphaComposite.Clear);

                String colorStr = col.toUpperCase();
                ConnectStraight(colorStr);
                g2.setColor(curColor.getCol());

                ArrayList<String> newStack = new ArrayList<>();
                boolean in = false;

                for (String s : callStack) {
                    String sStr = s.toUpperCase();
                    if (sStr.contains(colorStr) && sStr.contains("ERASE")) {
                        continue;
                    } else if (sStr.contains(colorStr)) {
                        in = true;
                    } else if (in && sStr.contains("MARK")) {
                        in = true;
                    } else {
                        if (sStr.contains("CHOOSE") || sStr.contains("CONNECT")) {
                            in = false;
                        }
                        newStack.add(s);
                    }
                }
                callStack = newStack;
                initPoints();
                curX = frameX / 2;
                curY = frameY / 2;

                for (int i = 0; i < callStack.size(); i++) {
                    System.out.println(callStack.get(i));
                }

                repaint();
            }
        };
        window.add(jComponent);

        String s = node.getNumber().toString();
        s = s.replaceAll("\\s", "");
        int size = Integer.parseInt(s);
//        System.out.println("init  size "+s);
//        System.out.println("THe valus of size "+size);
        if (size < 0) {
            if (popupEnabled) {
                JOptionPane.showMessageDialog(null,
                        "\"Size\" command can not be negative",
                        "RIGHT error",
                        JOptionPane.WARNING_MESSAGE);
                popupEnabled = false;
            }

        }
        if (size > 100) {
            init_size = 10;
            size = 100;
        } else {
            init_size = 10;
        }
        grid(size * init_size, size * init_size);

        window.setTitle("Drawing");
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);

    }



    public static void grid(int x, int y) {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();

        if (x < 150 || y < 150) {
            frameX = 150;
            frameY = 150;
        } else if (x > screenWidth || y > screenHeight) {
            frameX = screenHeight - 10;
            frameY = screenHeight - 10;
        } else {
            frameX = x;
            frameY = y;
        }
        window.setSize(frameX, frameY);

    }
	
	public void initPoints(){
        int i = 0;
        for (Colors c: Colors.values()) {
            points.add(i, new ArrayList<>(Arrays.asList()));
            i++;
        }
    }
}
