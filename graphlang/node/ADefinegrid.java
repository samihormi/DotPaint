/* This file was generated by SableCC (http://www.sablecc.org/). */

package graphlang.node;

import graphlang.analysis.*;

@SuppressWarnings("nls")
public final class ADefinegrid extends PDefinegrid
{
    private TKeywordgrid _keywordgrid_;
    private TMinus _minus_;
    private TNumber _number_;

    public ADefinegrid()
    {
        // Constructor
    }

    public ADefinegrid(
        @SuppressWarnings("hiding") TKeywordgrid _keywordgrid_,
        @SuppressWarnings("hiding") TMinus _minus_,
        @SuppressWarnings("hiding") TNumber _number_)
    {
        // Constructor
        setKeywordgrid(_keywordgrid_);

        setMinus(_minus_);

        setNumber(_number_);

    }

    @Override
    public Object clone()
    {
        return new ADefinegrid(
            cloneNode(this._keywordgrid_),
            cloneNode(this._minus_),
            cloneNode(this._number_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADefinegrid(this);
    }

    public TKeywordgrid getKeywordgrid()
    {
        return this._keywordgrid_;
    }

    public void setKeywordgrid(TKeywordgrid node)
    {
        if(this._keywordgrid_ != null)
        {
            this._keywordgrid_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._keywordgrid_ = node;
    }

    public TMinus getMinus()
    {
        return this._minus_;
    }

    public void setMinus(TMinus node)
    {
        if(this._minus_ != null)
        {
            this._minus_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._minus_ = node;
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._keywordgrid_)
            + toString(this._minus_)
            + toString(this._number_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._keywordgrid_ == child)
        {
            this._keywordgrid_ = null;
            return;
        }

        if(this._minus_ == child)
        {
            this._minus_ = null;
            return;
        }

        if(this._number_ == child)
        {
            this._number_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._keywordgrid_ == oldChild)
        {
            setKeywordgrid((TKeywordgrid) newChild);
            return;
        }

        if(this._minus_ == oldChild)
        {
            setMinus((TMinus) newChild);
            return;
        }

        if(this._number_ == oldChild)
        {
            setNumber((TNumber) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
