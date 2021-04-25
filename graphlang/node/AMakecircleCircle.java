/* This file was generated by SableCC (http://www.sablecc.org/). */

package graphlang.node;

import graphlang.analysis.*;

@SuppressWarnings("nls")
public final class AMakecircleCircle extends PCircle
{
    private TKeywordcircle _keywordcircle_;
    private TNumber _number_;
    private TColor _color_;
    private TColor _parameter_;

    public AMakecircleCircle()
    {
        // Constructor
    }

    public AMakecircleCircle(
        @SuppressWarnings("hiding") TKeywordcircle _keywordcircle_,
        @SuppressWarnings("hiding") TNumber _number_,
        @SuppressWarnings("hiding") TColor _color_,
        @SuppressWarnings("hiding") TColor _parameter_)
    {
        // Constructor
        setKeywordcircle(_keywordcircle_);

        setNumber(_number_);

        setColor(_color_);

        setParameter(_parameter_);

    }

    @Override
    public Object clone()
    {
        return new AMakecircleCircle(
            cloneNode(this._keywordcircle_),
            cloneNode(this._number_),
            cloneNode(this._color_),
            cloneNode(this._parameter_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMakecircleCircle(this);
    }

    public TKeywordcircle getKeywordcircle()
    {
        return this._keywordcircle_;
    }

    public void setKeywordcircle(TKeywordcircle node)
    {
        if(this._keywordcircle_ != null)
        {
            this._keywordcircle_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._keywordcircle_ = node;
    }

    public TNumber getNumber()
    {
        return this._number_;
    }

    public void setNumber(TNumber node)
    {
        if(this._number_ != null)
        {
            this._number_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._number_ = node;
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

    public TColor getParameter()
    {
        return this._parameter_;
    }

    public void setParameter(TColor node)
    {
        if(this._parameter_ != null)
        {
            this._parameter_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parameter_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._keywordcircle_)
            + toString(this._number_)
            + toString(this._color_)
            + toString(this._parameter_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._keywordcircle_ == child)
        {
            this._keywordcircle_ = null;
            return;
        }

        if(this._number_ == child)
        {
            this._number_ = null;
            return;
        }

        if(this._color_ == child)
        {
            this._color_ = null;
            return;
        }

        if(this._parameter_ == child)
        {
            this._parameter_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._keywordcircle_ == oldChild)
        {
            setKeywordcircle((TKeywordcircle) newChild);
            return;
        }

        if(this._number_ == oldChild)
        {
            setNumber((TNumber) newChild);
            return;
        }

        if(this._color_ == oldChild)
        {
            setColor((TColor) newChild);
            return;
        }

        if(this._parameter_ == oldChild)
        {
            setParameter((TColor) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
