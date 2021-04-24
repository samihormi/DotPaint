/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import java.util.*;
import org.sablecc.sablecc.analysis.*;

public final class ADecChar extends PChar
{
  private TDecChar _decChar_;

  public ADecChar()
  {}

  public ADecChar(
    TDecChar _decChar_)
  {
    setDecChar(_decChar_);

  }
  public Object clone()
  {
    return new ADecChar(
             (TDecChar) cloneNode(_decChar_));
  }

  public void apply(Switch sw)
  {
    ((Analysis) sw).caseADecChar(this);
  }

  public TDecChar getDecChar()
  {
    return _decChar_;
  }

  public void setDecChar(TDecChar node)
  {
    if(_decChar_ != null)
    {
      _decChar_.parent(null);
    }

    if(node != null)
    {
      if(node.parent() != null)
      {
        node.parent().removeChild(node);
      }

      node.parent(this);
    }

    _decChar_ = node;
  }

  public String toString()
  {
    return ""
           + toString(_decChar_);
  }

  void removeChild(Node child)
  {
    if(_decChar_ == child)
    {
      _decChar_ = null;
      return;
    }

  }

  void replaceChild(Node oldChild, Node newChild)
  {
    if(_decChar_ == oldChild)
    {
      setDecChar((TDecChar) newChild);
      return;
    }

  }
}
