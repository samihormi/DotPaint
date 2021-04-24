package graphlang;

import graphlang.node.*;
import graphlang.analysis.*;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Ellipse2D;

import java.util.ArrayList;
import java.util.Arrays;

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
        GREEN(2, Color.GREEN);

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
    public static JFrame window;

    public static Colors curColor = Colors.RED;
	public static boolean up = false;
	private static int calls = 0;

    static ArrayList<ArrayList<Coordinate>> points = new ArrayList<>(); // Colors, Coordinates
    static ArrayList<String> callStack = new ArrayList<>();
    static Graphics2D g2;

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
	
	public void outAErasecolorErase(AErasecolorErase node){
		callStack.add(node.toString());
	}

    public void outADefineDefinegrid(ADefineDefinegrid node){
        initPoints();
		
		window = new JFrame();
		JComponent jComponent = new JComponent() {

            @Override
            protected void paintComponent(Graphics g) {
				
                g2 = (Graphics2D) g;
				
				calls++;
				
				/*if(calls % 2 == 0){
					update();
				}*/
				curX = 0;
				curY = 0;
				update();
				
				
            }
			
			public void update(){
				
				g2.setColor(curColor.getCol());
               
				for (int i = 0; i < callStack.size(); i++) {
                    String cur = callStack.get(i);
					StringTokenizer st = new StringTokenizer(cur, " ");
					
                    switch(st.nextToken().toUpperCase()){
						case "CONNECT":{
							String col = st.nextToken();
							String type = st.nextToken();
							if(type.equals("CURVED")){
								ConnectCurved(col);
							}
							else{
								ConnectStraight(col); 
							}
							break;
						}
						case "MARK":{
							MarkPoint();
							break;
						}
						case "MOVE":{
							Move(st.nextToken(), st.nextToken());
							break;
						}
						case "CHOOSE":{
							ChooseColor(st.nextToken());
							break;
						}
						case "CIRCLE":{
							DrawCircle(st.nextToken(),st.nextToken());
							break;
						}
						case "ERASE":{
							EraseShape(st.nextToken());
							break;
						}
                        
                    }
                }
				// Show current position
				g2.setColor(Color.BLACK);
				g2.setStroke(new BasicStroke(3.0f));
				g2.drawLine(curX, curY, curX, curY);
				g2.setColor(curColor.getCol());
				g2.setStroke(new BasicStroke(2.0f));
				
				//callStack = new ArrayList<>();
			}
			
			public void ChooseColor(String str){
				curColor = Colors.valueOf(str);
				g2.setColor(curColor.getCol());
			}
			void isValid(int cur, int future){

            }

            public void Move(String dir, String s){
				
				int z = Integer.parseInt(s);
			
				int newX = curX;
				int newY = curY;

                switch (dir.toUpperCase()) {
                    case "UP" -> {
                        if (curY - z < 0) {
                            JOptionPane.showMessageDialog(null,
                                    "\"MOVE UP\" command goes beyond the frame size",
                                    "UP error",
                                    JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        newY = curY - z;
                        break;
                    }
                    case "DOWN" -> {
                        if (curY + z > window.getY()) {
                            JOptionPane.showMessageDialog(null,
                                    "\"MOVE DOWN\" command goes beyond the frame size",
                                    "DOWN eroro",
                                    JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        newY = curY + z;
                        break;
                    }
                    case "LEFT" -> {
                        if (curY - z < 0) {
                            JOptionPane.showMessageDialog(null,
                                    "\"MOVE LEFT\" command goes beyond the frame size",
                                    "DOWN error",
                                    JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        newX = curX - z;
                        break;
                    }
                    case "RIGHT" -> {
                        if (curX + z > window.getX()) {
                            JOptionPane.showMessageDialog(null,
                                    "\"MOVE RIGHT\" command goes beyond the frame size",
                                    "RIGHT error",
                                    JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        newX = curX + z;
                        break;
                    }
                }
				if(newX > frameX || newY > frameY){
						System.out.println("Index out of frame");
				}
				else{
						curX = newX;
						curY = newY;
				}
            }

            public void MarkPoint(){
                points.get(curColor.getNum()).add(new Coordinate(curX,curY));
            }

            public void ConnectStraight(String str){
				Colors color = Colors.valueOf(str);
				g2.setColor(color.getCol());
                if(points.get(color.getNum()).size() != 0){
                    //g2.setColor(curColor);
                    g2.setStroke(new BasicStroke(2.0f));
                    GeneralPath path = new GeneralPath(GeneralPath.WIND_NON_ZERO);

                    path.moveTo(points.get(color.getNum()).get(0).getX(), points.get(color.getNum()).get(0).getY());

                    for (int i = 1; i < points.get(color.getNum()).size(); i++) {
                        path.lineTo(points.get(color.getNum()).get(i).getX(),points.get(color.getNum()).get(i).getY());
                    }

                    path.closePath();
                    g2.draw(path);
                }
				g2.setColor(curColor.getCol());
            }
			
			public void ConnectCurved(String str){
				Colors color = Colors.valueOf(str);
                g2.setStroke(new BasicStroke(2.0f));
                
                GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);

                path.moveTo(points.get(color.getNum()).get(0).getX(), points.get(color.getNum()).get(0).getY());

                for (int i = 1; i < points.get(color.getNum()).size(); i++) {
                    int posX = points.get(color.getNum()).get(i).getX();
                    int posY = points.get(color.getNum()).get(i).getY();
                    path.lineTo(posX,posY);
                
                }

                int p1X = 0, p1Y = 0, p2X = 0, p2Y = 0, p3X = 0, p3Y = 0;
                int count = 0;
                for (int i = 1; i < points.get(color.getNum()).size(); i++) {
                    int posX = points.get(color.getNum()).get(i).getX();
                    int posY = points.get(color.getNum()).get(i).getY();
                    if(count == 0){
                        p1X = posX;
                        p1Y = posY;
                        count++;
                    }
                    else if(count == 1){
                        p2X = posX;
                        p2Y = posY;
                        count++;
                    }
                    else if(count == 2){
                        p3X = posX;
                        p3Y = posY;
                        count = 0;
                        path.curveTo(p1X, p1Y, p2X, p2Y, p3X, p3Y);
                    }
                }

                path.curveTo(150, 150, 300, 300, 50, 250);
                path.closePath();
                g2.draw(path);
            }
			
			public void DrawCircle(String col, String di){
				Colors color = Colors.valueOf(col);
				int diameter = Integer.parseInt(di);
                if(!points.get(color.getNum()).isEmpty()){
                    Coordinate position = points.get(color.getNum()).get(0);
					int half_diameter = diameter/2;
                    Ellipse2D.Double circle = new Ellipse2D.Double(position.getX() - half_diameter, position.getY() - half_diameter, diameter, diameter);
                    g2.draw(circle);
                }
            }
			
			public void EraseShape(String col){
				//Colors color = Colors.valueOf(col);
				g2.setColor(new Color(0, 0, 0,0));
                g2.setComposite(AlphaComposite.Clear);

                ConnectStraight(col);
                g2.setColor(curColor.getCol());
				
				ArrayList<String> newStack = new ArrayList<>();
				boolean in = false;
				
				for (String s: callStack){
					if(s.contains(col) && s.contains("ERASE")){
						continue;
					}
					else if(s.contains(col)){
						in = true;
					}
					else if(in && s.contains("MARK")){
						in = true;
					}
					else{
						if(s.contains("CHOOSE") || s.contains("CONNECT")){
							in = false;
						}
						newStack.add(s);
					}
				}
				callStack = newStack;
				initPoints();
				curX = 0;
				curY = 0;
				repaint();
			}
        };
        window.add(jComponent);
	
	String s = node.getNumber().toString();
	s = s.replaceAll("\\s", "");
	int size = Integer.parseInt(s);
	make(size,size);
	
	window.setTitle("Drawing");
	window.setLocationRelativeTo(null); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);

    }

    public static void make(int x, int y){
        frameX = x;
        frameY = y;
        window.setSize(frameX,frameY);
    }
	
	public void initPoints(){
        int i = 0;
        for (Colors c: Colors.values()) {
            points.add(i, new ArrayList<>(Arrays.asList()));
            i++;
        }
    }
}
