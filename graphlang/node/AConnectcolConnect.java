/* This file was generated by SableCC (http://www.sablecc.org/). */

package graphlang.node;

import graphlang.analysis.*;

@SuppressWarnings("nls")
public final class AConnectcolConnect extends PConnect
{
    private PConnectcolor _connectcolor_;

    public AConnectcolConnect()
    {
        // Constructor
    }

    public AConnectcolConnect(
        @SuppressWarnings("hiding") PConnectcolor _connectcolor_)
    {
        // Constructor
        setConnectcolor(_connectcolor_);

    }

    @Override
    public Object clone()
    {
        return new AConnectcolConnect(
            cloneNode(this._connectcolor_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAConnectcolConnect(this);
    }

    public PConnectcolor getConnectcolor()
    {
        return this._connectcolor_;
    }

    public void setConnectcolor(PConnectcolor node)
    {
        if(this._connectcolor_ != null)
        {
            this._connectcolor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._connectcolor_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._connectcolor_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._connectcolor_ == child)
        {
            this._connectcolor_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._connectcolor_ == oldChild)
        {
            setConnectcolor((PConnectcolor) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}