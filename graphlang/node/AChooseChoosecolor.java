/* This file was generated by SableCC (http://www.sablecc.org/). */

package graphlang.node;

import graphlang.analysis.*;

@SuppressWarnings("nls")
public final class AChooseChoosecolor extends PChoosecolor
{
    private TKeywordchoose _keywordchoose_;
    private TColor _color_;

    public AChooseChoosecolor()
    {
        // Constructor
    }

    public AChooseChoosecolor(
        @SuppressWarnings("hiding") TKeywordchoose _keywordchoose_,
        @SuppressWarnings("hiding") TColor _color_)
    {
        // Constructor
        setKeywordchoose(_keywordchoose_);

        setColor(_color_);

    }

    @Override
    public Object clone()
    {
        return new AChooseChoosecolor(
            cloneNode(this._keywordchoose_),
            cloneNode(this._color_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAChooseChoosecolor(this);
    }

    public TKeywordchoose getKeywordchoose()
    {
        return this._keywordchoose_;
    }

    public void setKeywordchoose(TKeywordchoose node)
    {
        if(this._keywordchoose_ != null)
        {
            this._keywordchoose_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._keywordchoose_ = node;
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
            + toString(this._keywordchoose_)
            + toString(this._color_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._keywordchoose_ == child)
        {
            this._keywordchoose_ = null;
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
        if(this._keywordchoose_ == oldChild)
        {
            setKeywordchoose((TKeywordchoose) newChild);
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
