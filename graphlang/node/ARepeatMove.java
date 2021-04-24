/* This file was generated by SableCC (http://www.sablecc.org/). */

package graphlang.node;

import graphlang.analysis.*;

@SuppressWarnings("nls")
public final class ARepeatMove extends PMove
{
    private TDirection _direction_;
    private TNumber _number_;
    private PMove _move_;

    public ARepeatMove()
    {
        // Constructor
    }

    public ARepeatMove(
        @SuppressWarnings("hiding") TDirection _direction_,
        @SuppressWarnings("hiding") TNumber _number_,
        @SuppressWarnings("hiding") PMove _move_)
    {
        // Constructor
        setDirection(_direction_);

        setNumber(_number_);

        setMove(_move_);

    }

    @Override
    public Object clone()
    {
        return new ARepeatMove(
            cloneNode(this._direction_),
            cloneNode(this._number_),
            cloneNode(this._move_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARepeatMove(this);
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

    public PMove getMove()
    {
        return this._move_;
    }

    public void setMove(PMove node)
    {
        if(this._move_ != null)
        {
            this._move_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._move_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._direction_)
            + toString(this._number_)
            + toString(this._move_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
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

        if(this._move_ == child)
        {
            this._move_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
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

        if(this._move_ == oldChild)
        {
            setMove((PMove) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
