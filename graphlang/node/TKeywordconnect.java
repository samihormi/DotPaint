/* This file was generated by SableCC (http://www.sablecc.org/). */

package graphlang.node;

import graphlang.analysis.*;

@SuppressWarnings("nls")
public final class TKeywordconnect extends Token
{
    public TKeywordconnect()
    {
        super.setText("CONNECT");
    }

    public TKeywordconnect(int line, int pos)
    {
        super.setText("CONNECT");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TKeywordconnect(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKeywordconnect(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKeywordconnect text.");
    }
}
