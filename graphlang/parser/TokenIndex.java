/* This file was generated by SableCC (http://www.sablecc.org/). */

package graphlang.parser;

import graphlang.node.*;
import graphlang.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTKeywordgrid(@SuppressWarnings("unused") TKeywordgrid node)
    {
        this.index = 0;
    }

    @Override
    public void caseTKeywordmove(@SuppressWarnings("unused") TKeywordmove node)
    {
        this.index = 1;
    }

    @Override
    public void caseTKeywordmark(@SuppressWarnings("unused") TKeywordmark node)
    {
        this.index = 2;
    }

    @Override
    public void caseTKeywordchoose(@SuppressWarnings("unused") TKeywordchoose node)
    {
        this.index = 3;
    }

    @Override
    public void caseTKeywordconnect(@SuppressWarnings("unused") TKeywordconnect node)
    {
        this.index = 4;
    }

    @Override
    public void caseTKeywordcircle(@SuppressWarnings("unused") TKeywordcircle node)
    {
        this.index = 5;
    }

    @Override
    public void caseTKeyworderase(@SuppressWarnings("unused") TKeyworderase node)
    {
        this.index = 6;
    }

    @Override
    public void caseTDirection(@SuppressWarnings("unused") TDirection node)
    {
        this.index = 7;
    }

    @Override
    public void caseTColor(@SuppressWarnings("unused") TColor node)
    {
        this.index = 8;
    }

    @Override
    public void caseTShape(@SuppressWarnings("unused") TShape node)
    {
        this.index = 9;
    }

    @Override
    public void caseTNumber(@SuppressWarnings("unused") TNumber node)
    {
        this.index = 10;
    }

    @Override
    public void caseTIdentifier(@SuppressWarnings("unused") TIdentifier node)
    {
        this.index = 11;
    }

    @Override
    public void caseTOpsemicolon(@SuppressWarnings("unused") TOpsemicolon node)
    {
        this.index = 12;
    }

    @Override
    public void caseTOpequal(@SuppressWarnings("unused") TOpequal node)
    {
        this.index = 13;
    }

    @Override
    public void caseTMinus(@SuppressWarnings("unused") TMinus node)
    {
        this.index = 14;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 15;
    }
}
