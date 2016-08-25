/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.measure.Quantity;
import javax.measure.QuantityProvider;
import javax.measure.Unit;

/**
 * @author <a href="mailto:desruisseaux@users.sourceforge.net">Martin Desruisseaux</a>
 * @version 0.1 ($Revision: 126 $), $Date: 2010-02-17 09:41:38 +0100 (Mi, 17 Feb 2010) $
 */
public final class QuantityFactory implements QuantityProvider {

  private QuantityFactory() {
  }

  private static final QuantityProvider INSTANCE = new QuantityFactory();

  public static final QuantityProvider getInstance() {
    return INSTANCE;
}

  /* (non-Javadoc)
 * @see javax.measure.util.QuantityProvider#create(java.lang.Class, java.lang.Number, javax.measure.Unit)
 */
@SuppressWarnings("unchecked")
public final <Q extends Quantity> Q create(final Class<Q> type, final Number value, final Unit<?> unit) {
    return (Q) Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[] {type}, new InvocationHandler() {

      public Object invoke(final Object proxy, final Method method, final Object[] args) {
        final String name = method.getName();
        // XXX: use switch on String if we are allowed to compile for Java 7.
        if (name.equals("getValue")) {
          return value;
        }
        if (name.equals("getUnit")) {
          return unit;
        }
        if (name.equals("toString")) {
          final StringBuilder buffer = new StringBuilder();
          return buffer.append(value).append(' ').append(unit).toString();
        }
        if (name.equals("hashCode")) {
          return value.hashCode() + 31 * unit.hashCode();
        }
        if (name.equals("equals")) {
          // TODO implement
        }
        throw new UnsupportedOperationException(name);
      }
    });
  }
}
