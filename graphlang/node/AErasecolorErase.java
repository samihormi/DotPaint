/* This file was generated by SableCC (http://www.sablecc.org/). */

package graphlang.node;

import graphlang.analysis.*;

@SuppressWarnings("nls")
public final class AErasecolorErase extends PErase
{
    private TKeyworderase _keyworderase_;
    private TColor _color_;

    public AErasecolorErase()
    {
        // Constructor
    }

    public AErasecolorErase(
        @SuppressWarnings("hiding") TKeyworderase _keyworderase_,
        @SuppressWarnings("hiding") TColor _color_)
    {
        // Constructor
        setKeyworderase(_keyworderase_);

        setColor(_color_);

    }

    @Override
    public Object clone()
    {
        return new AErasecolorErase(
            cloneNode(this._keyworderase_),
            cloneNode(this._color_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAErasecolorErase(this);
    }

    public TKeyworderase getKeyworderase()
    {
        return this._keyworderase_;
    }

    public void setKeyworderase(TKeyworderase node)
    {
        if(this._keyworderase_ != null)
        {
            this._keyworderase_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._keyworderase_ = node;
    }

    public TColor getColor()
    {
        return this._color_;
    }

    public void setColor(TColor node)
    {
        if(this._color_ != null)
        {
            this._color_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._color_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._keyworderase_)
            + toString(this._color_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._keyworderase_ == child)
        {
            this._keyworderase_ = null;
            return;
        }

        if(this._color_ == child)
        {
            this._color_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._keyworderase_ == oldChild)
        {
            setKeyworderase((TKeyworderase) newChild);
            return;
        }

        if(this._color_ == oldChild)
        {
            setColor((TColor) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
