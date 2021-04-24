/* This file was generated by SableCC (http://www.sablecc.org/). */

package graphlang.node;

import graphlang.analysis.*;

@SuppressWarnings("nls")
public final class AMoveMove extends PMove
{
    private TKeywordmove _keywordmove_;
    private TDirection _direction_;
    private TNumber _number_;

    public AMoveMove()
    {
        // Constructor
    }

    public AMoveMove(
        @SuppressWarnings("hiding") TKeywordmove _keywordmove_,
        @SuppressWarnings("hiding") TDirection _direction_,
        @SuppressWarnings("hiding") TNumber _number_)
    {
        // Constructor
        setKeywordmove(_keywordmove_);

        setDirection(_direction_);

        setNumber(_number_);

    }

    @Override
    public Object clone()
    {
        return new AMoveMove(
            cloneNode(this._keywordmove_),
            cloneNode(this._direction_),
            cloneNode(this._number_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMoveMove(this);
    }

    public TKeywordmove getKeywordmove()
    {
        return this._keywordmove_;
    }

    public void setKeywordmove(TKeywordmove node)
    {
        if(this._keywordmove_ != null)
        {
            this._keywordmove_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._keywordmove_ = node;
    }

    public TDirection getDirection()
    {
        return this._direction_;
    }

    public void setDirection(TDirection node)
    {
        if(this._direction_ != null)
        {
            this._direction_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._direction_ = node;
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
            + toString(this._keywordmove_)
            + toString(this._direction_)
            + toString(this._number_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._keywordmove_ == child)
        {
            this._keywordmove_ = null;
            return;
        }

        if(this._direction_ == child)
        {
            this._direction_ = null;
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
        if(this._keywordmove_ == oldChild)
        {
            setKeywordmove((TKeywordmove) newChild);
            return;
        }

        if(this._direction_ == oldChild)
        {
            setDirection((TDirection) newChild);
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