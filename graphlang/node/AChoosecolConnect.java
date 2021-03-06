/* This file was generated by SableCC (http://www.sablecc.org/). */

package graphlang.node;

import graphlang.analysis.*;

@SuppressWarnings("nls")
public final class AChoosecolConnect extends PConnect
{
    private PChoosecolor _choosecolor_;

    public AChoosecolConnect()
    {
        // Constructor
    }

    public AChoosecolConnect(
        @SuppressWarnings("hiding") PChoosecolor _choosecolor_)
    {
        // Constructor
        setChoosecolor(_choosecolor_);

    }

    @Override
    public Object clone()
    {
        return new AChoosecolConnect(
            cloneNode(this._choosecolor_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAChoosecolConnect(this);
    }

    public PChoosecolor getChoosecolor()
    {
        return this._choosecolor_;
    }

    public void setChoosecolor(PChoosecolor node)
    {
        if(this._choosecolor_ != null)
        {
            this._choosecolor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._choosecolor_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._choosecolor_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._choosecolor_ == child)
        {
            this._choosecolor_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._choosecolor_ == oldChild)
        {
            setChoosecolor((PChoosecolor) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
