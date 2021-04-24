/* This file was generated by SableCC (http://www.sablecc.org/). */

package graphlang.node;

import graphlang.analysis.*;

@SuppressWarnings("nls")
public final class AConnDraw extends PDraw
{
    private PConnect _connect_;

    public AConnDraw()
    {
        // Constructor
    }

    public AConnDraw(
        @SuppressWarnings("hiding") PConnect _connect_)
    {
        // Constructor
        setConnect(_connect_);

    }

    @Override
    public Object clone()
    {
        return new AConnDraw(
            cloneNode(this._connect_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAConnDraw(this);
    }

    public PConnect getConnect()
    {
        return this._connect_;
    }

    public void setConnect(PConnect node)
    {
        if(this._connect_ != null)
        {
            this._connect_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._connect_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._connect_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._connect_ == child)
        {
            this._connect_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._connect_ == oldChild)
        {
            setConnect((PConnect) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
