/* This file was generated by SableCC (http://www.sablecc.org/). */

package graphlang.analysis;

import java.util.*;
import graphlang.node.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getEOF().apply(this);
        node.getPProgram().apply(this);
        outStart(node);
    }

    public void inAProgram(AProgram node)
    {
        defaultIn(node);
    }

    public void outAProgram(AProgram node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAProgram(AProgram node)
    {
        inAProgram(node);
        if(node.getStmtlist() != null)
        {
            node.getStmtlist().apply(this);
        }
        if(node.getDefinegrid() != null)
        {
            node.getDefinegrid().apply(this);
        }
        outAProgram(node);
    }

    public void inAStmtStmtlist(AStmtStmtlist node)
    {
        defaultIn(node);
    }

    public void outAStmtStmtlist(AStmtStmtlist node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStmtStmtlist(AStmtStmtlist node)
    {
        inAStmtStmtlist(node);
        if(node.getStmt() != null)
        {
            node.getStmt().apply(this);
        }
        outAStmtStmtlist(node);
    }

    public void inAListStmtlist(AListStmtlist node)
    {
        defaultIn(node);
    }

    public void outAListStmtlist(AListStmtlist node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListStmtlist(AListStmtlist node)
    {
        inAListStmtlist(node);
        if(node.getStmtlist() != null)
        {
            node.getStmtlist().apply(this);
        }
        if(node.getStmt() != null)
        {
            node.getStmt().apply(this);
        }
        outAListStmtlist(node);
    }

    public void inAMoveStmt(AMoveStmt node)
    {
        defaultIn(node);
    }

    public void outAMoveStmt(AMoveStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMoveStmt(AMoveStmt node)
    {
        inAMoveStmt(node);
        if(node.getMove() != null)
        {
            node.getMove().apply(this);
        }
        outAMoveStmt(node);
    }

    public void inADrawStmt(ADrawStmt node)
    {
        defaultIn(node);
    }

    public void outADrawStmt(ADrawStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADrawStmt(ADrawStmt node)
    {
        inADrawStmt(node);
        if(node.getDraw() != null)
        {
            node.getDraw().apply(this);
        }
        outADrawStmt(node);
    }

    public void inAFillStmt(AFillStmt node)
    {
        defaultIn(node);
    }

    public void outAFillStmt(AFillStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFillStmt(AFillStmt node)
    {
        inAFillStmt(node);
        if(node.getColorize() != null)
        {
            node.getColorize().apply(this);
        }
        outAFillStmt(node);
    }

    public void inADefineDefinegrid(ADefineDefinegrid node)
    {
        defaultIn(node);
    }

    public void outADefineDefinegrid(ADefineDefinegrid node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADefineDefinegrid(ADefineDefinegrid node)
    {
        inADefineDefinegrid(node);
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        if(node.getKeywordgrid() != null)
        {
            node.getKeywordgrid().apply(this);
        }
        outADefineDefinegrid(node);
    }

    public void inAMoveMove(AMoveMove node)
    {
        defaultIn(node);
    }

    public void outAMoveMove(AMoveMove node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMoveMove(AMoveMove node)
    {
        inAMoveMove(node);
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        if(node.getDirection() != null)
        {
            node.getDirection().apply(this);
        }
        outAMoveMove(node);
    }

    public void inAConnDraw(AConnDraw node)
    {
        defaultIn(node);
    }

    public void outAConnDraw(AConnDraw node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAConnDraw(AConnDraw node)
    {
        inAConnDraw(node);
        if(node.getConnect() != null)
        {
            node.getConnect().apply(this);
        }
        outAConnDraw(node);
    }

    public void inACircDraw(ACircDraw node)
    {
        defaultIn(node);
    }

    public void outACircDraw(ACircDraw node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACircDraw(ACircDraw node)
    {
        inACircDraw(node);
        if(node.getCircle() != null)
        {
            node.getCircle().apply(this);
        }
        outACircDraw(node);
    }

    public void inAErasecolDraw(AErasecolDraw node)
    {
        defaultIn(node);
    }

    public void outAErasecolDraw(AErasecolDraw node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAErasecolDraw(AErasecolDraw node)
    {
        inAErasecolDraw(node);
        if(node.getErase() != null)
        {
            node.getErase().apply(this);
        }
        outAErasecolDraw(node);
    }

    public void inASqDraw(ASqDraw node)
    {
        defaultIn(node);
    }

    public void outASqDraw(ASqDraw node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASqDraw(ASqDraw node)
    {
        inASqDraw(node);
        if(node.getSquare() != null)
        {
            node.getSquare().apply(this);
        }
        outASqDraw(node);
    }

    public void inATriDraw(ATriDraw node)
    {
        defaultIn(node);
    }

    public void outATriDraw(ATriDraw node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATriDraw(ATriDraw node)
    {
        inATriDraw(node);
        if(node.getTriangle() != null)
        {
            node.getTriangle().apply(this);
        }
        outATriDraw(node);
    }

    public void inARectDraw(ARectDraw node)
    {
        defaultIn(node);
    }

    public void outARectDraw(ARectDraw node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARectDraw(ARectDraw node)
    {
        inARectDraw(node);
        if(node.getRectangle() != null)
        {
            node.getRectangle().apply(this);
        }
        outARectDraw(node);
    }

    public void inARhoDraw(ARhoDraw node)
    {
        defaultIn(node);
    }

    public void outARhoDraw(ARhoDraw node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARhoDraw(ARhoDraw node)
    {
        inARhoDraw(node);
        if(node.getRhombus() != null)
        {
            node.getRhombus().apply(this);
        }
        outARhoDraw(node);
    }

    public void inAFillrColorize(AFillrColorize node)
    {
        defaultIn(node);
    }

    public void outAFillrColorize(AFillrColorize node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFillrColorize(AFillrColorize node)
    {
        inAFillrColorize(node);
        {
            List<TColor> copy = new ArrayList<TColor>(node.getColor());
            Collections.reverse(copy);
            for(TColor e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getKeywordfill() != null)
        {
            node.getKeywordfill().apply(this);
        }
        outAFillrColorize(node);
    }

    public void inAMakecircleCircle(AMakecircleCircle node)
    {
        defaultIn(node);
    }

    public void outAMakecircleCircle(AMakecircleCircle node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMakecircleCircle(AMakecircleCircle node)
    {
        inAMakecircleCircle(node);
        if(node.getColor() != null)
        {
            node.getColor().apply(this);
        }
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        if(node.getKeywordcircle() != null)
        {
            node.getKeywordcircle().apply(this);
        }
        outAMakecircleCircle(node);
    }

    public void inAMakesquareSquare(AMakesquareSquare node)
    {
        defaultIn(node);
    }

    public void outAMakesquareSquare(AMakesquareSquare node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMakesquareSquare(AMakesquareSquare node)
    {
        inAMakesquareSquare(node);
        if(node.getColor() != null)
        {
            node.getColor().apply(this);
        }
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        if(node.getKeywordsquare() != null)
        {
            node.getKeywordsquare().apply(this);
        }
        outAMakesquareSquare(node);
    }

    public void inAMaketriangleTriangle(AMaketriangleTriangle node)
    {
        defaultIn(node);
    }

    public void outAMaketriangleTriangle(AMaketriangleTriangle node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMaketriangleTriangle(AMaketriangleTriangle node)
    {
        inAMaketriangleTriangle(node);
        if(node.getTritype() != null)
        {
            node.getTritype().apply(this);
        }
        if(node.getColor() != null)
        {
            node.getColor().apply(this);
        }
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        if(node.getKeywordtriangle() != null)
        {
            node.getKeywordtriangle().apply(this);
        }
        outAMaketriangleTriangle(node);
    }

    public void inAMakerectangleRectangle(AMakerectangleRectangle node)
    {
        defaultIn(node);
    }

    public void outAMakerectangleRectangle(AMakerectangleRectangle node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMakerectangleRectangle(AMakerectangleRectangle node)
    {
        inAMakerectangleRectangle(node);
        if(node.getColor() != null)
        {
            node.getColor().apply(this);
        }
        if(node.getParameter() != null)
        {
            node.getParameter().apply(this);
        }
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        if(node.getKeywordrectangle() != null)
        {
            node.getKeywordrectangle().apply(this);
        }
        outAMakerectangleRectangle(node);
    }

    public void inAMakerhombusRhombus(AMakerhombusRhombus node)
    {
        defaultIn(node);
    }

    public void outAMakerhombusRhombus(AMakerhombusRhombus node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMakerhombusRhombus(AMakerhombusRhombus node)
    {
        inAMakerhombusRhombus(node);
        if(node.getColor() != null)
        {
            node.getColor().apply(this);
        }
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        if(node.getKeywordrhombus() != null)
        {
            node.getKeywordrhombus().apply(this);
        }
        outAMakerhombusRhombus(node);
    }

    public void inAMarkConnect(AMarkConnect node)
    {
        defaultIn(node);
    }

    public void outAMarkConnect(AMarkConnect node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMarkConnect(AMarkConnect node)
    {
        inAMarkConnect(node);
        if(node.getMarkpoint() != null)
        {
            node.getMarkpoint().apply(this);
        }
        outAMarkConnect(node);
    }

    public void inAConnectcolConnect(AConnectcolConnect node)
    {
        defaultIn(node);
    }

    public void outAConnectcolConnect(AConnectcolConnect node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAConnectcolConnect(AConnectcolConnect node)
    {
        inAConnectcolConnect(node);
        if(node.getConnectcolor() != null)
        {
            node.getConnectcolor().apply(this);
        }
        outAConnectcolConnect(node);
    }

    public void inAChoosecolConnect(AChoosecolConnect node)
    {
        defaultIn(node);
    }

    public void outAChoosecolConnect(AChoosecolConnect node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAChoosecolConnect(AChoosecolConnect node)
    {
        inAChoosecolConnect(node);
        if(node.getChoosecolor() != null)
        {
            node.getChoosecolor().apply(this);
        }
        outAChoosecolConnect(node);
    }

    public void inAConnectcolorConnectcolor(AConnectcolorConnectcolor node)
    {
        defaultIn(node);
    }

    public void outAConnectcolorConnectcolor(AConnectcolorConnectcolor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAConnectcolorConnectcolor(AConnectcolorConnectcolor node)
    {
        inAConnectcolorConnectcolor(node);
        if(node.getShape() != null)
        {
            node.getShape().apply(this);
        }
        if(node.getColor() != null)
        {
            node.getColor().apply(this);
        }
        if(node.getKeywordconnect() != null)
        {
            node.getKeywordconnect().apply(this);
        }
        outAConnectcolorConnectcolor(node);
    }

    public void inAChooseChoosecolor(AChooseChoosecolor node)
    {
        defaultIn(node);
    }

    public void outAChooseChoosecolor(AChooseChoosecolor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAChooseChoosecolor(AChooseChoosecolor node)
    {
        inAChooseChoosecolor(node);
        if(node.getColor() != null)
        {
            node.getColor().apply(this);
        }
        if(node.getKeywordchoose() != null)
        {
            node.getKeywordchoose().apply(this);
        }
        outAChooseChoosecolor(node);
    }

    public void inAMarkpoint(AMarkpoint node)
    {
        defaultIn(node);
    }

    public void outAMarkpoint(AMarkpoint node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMarkpoint(AMarkpoint node)
    {
        inAMarkpoint(node);
        if(node.getKeywordmark() != null)
        {
            node.getKeywordmark().apply(this);
        }
        outAMarkpoint(node);
    }

    public void inAErasecolorErase(AErasecolorErase node)
    {
        defaultIn(node);
    }

    public void outAErasecolorErase(AErasecolorErase node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAErasecolorErase(AErasecolorErase node)
    {
        inAErasecolorErase(node);
        if(node.getColor() != null)
        {
            node.getColor().apply(this);
        }
        if(node.getKeyworderase() != null)
        {
            node.getKeyworderase().apply(this);
        }
        outAErasecolorErase(node);
    }
}
