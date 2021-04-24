/* This file was generated by SableCC (http://www.sablecc.org/). */

package graphlang.analysis;

import java.util.*;
import graphlang.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    public void caseAProgram(AProgram node)
    {
        defaultCase(node);
    }

    public void caseAStmtStmtlist(AStmtStmtlist node)
    {
        defaultCase(node);
    }

    public void caseAListStmtlist(AListStmtlist node)
    {
        defaultCase(node);
    }

    public void caseAMoveStmt(AMoveStmt node)
    {
        defaultCase(node);
    }

    public void caseADrawStmt(ADrawStmt node)
    {
        defaultCase(node);
    }

    public void caseADefineDefinegrid(ADefineDefinegrid node)
    {
        defaultCase(node);
    }

    public void caseAMoveMove(AMoveMove node)
    {
        defaultCase(node);
    }

    public void caseAConnDraw(AConnDraw node)
    {
        defaultCase(node);
    }

    public void caseACircDraw(ACircDraw node)
    {
        defaultCase(node);
    }

    public void caseAErasecolDraw(AErasecolDraw node)
    {
        defaultCase(node);
    }

    public void caseAMakecircleCircle(AMakecircleCircle node)
    {
        defaultCase(node);
    }

    public void caseAMarkConnect(AMarkConnect node)
    {
        defaultCase(node);
    }

    public void caseAConnectcolConnect(AConnectcolConnect node)
    {
        defaultCase(node);
    }

    public void caseAChoosecolConnect(AChoosecolConnect node)
    {
        defaultCase(node);
    }

    public void caseAConnectcolorConnectcolor(AConnectcolorConnectcolor node)
    {
        defaultCase(node);
    }

    public void caseAChooseChoosecolor(AChooseChoosecolor node)
    {
        defaultCase(node);
    }

    public void caseAMarkpoint(AMarkpoint node)
    {
        defaultCase(node);
    }

    public void caseAErasecolorErase(AErasecolorErase node)
    {
        defaultCase(node);
    }

    public void caseTKeywordmake(TKeywordmake node)
    {
        defaultCase(node);
    }

    public void caseTKeywordmove(TKeywordmove node)
    {
        defaultCase(node);
    }

    public void caseTKeywordmark(TKeywordmark node)
    {
        defaultCase(node);
    }

    public void caseTKeywordchoose(TKeywordchoose node)
    {
        defaultCase(node);
    }

    public void caseTKeywordconnect(TKeywordconnect node)
    {
        defaultCase(node);
    }

    public void caseTKeywordcircle(TKeywordcircle node)
    {
        defaultCase(node);
    }

    public void caseTKeyworderase(TKeyworderase node)
    {
        defaultCase(node);
    }

    public void caseTDirection(TDirection node)
    {
        defaultCase(node);
    }

    public void caseTColor(TColor node)
    {
        defaultCase(node);
    }

    public void caseTShape(TShape node)
    {
        defaultCase(node);
    }

    public void caseTNumber(TNumber node)
    {
        defaultCase(node);
    }

    public void caseTIdentifier(TIdentifier node)
    {
        defaultCase(node);
    }

    public void caseTOpsemicolon(TOpsemicolon node)
    {
        defaultCase(node);
    }

    public void caseTOpequal(TOpequal node)
    {
        defaultCase(node);
    }

    public void caseTBlank(TBlank node)
    {
        defaultCase(node);
    }

    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
