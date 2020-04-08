/*
 * Copyright (c) 2007, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * $Id$
 */

package com.sun.ts.tests.jpa.core.callback.inheritance;

import com.sun.ts.tests.jpa.core.callback.common.CallbackStatusIF;
import com.sun.ts.tests.jpa.core.callback.common.CallbackStatusImpl;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT_TABLE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PRODUCT_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Product")
@EntityListeners(com.sun.ts.tests.jpa.core.callback.inheritance.ProductListener.class)
public class Product extends CallbackStatusImpl
    implements java.io.Serializable, CallbackStatusIF {
  private String id;

  private String name;

  private int quantity;

  public Product() {
    super();
  }

  public Product(String id, String name, int quantity) {
    this.id = id;
    this.name = name;
    this.quantity = quantity;
  }

  @Id
  @Column(name = "ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Column(name = "NAME")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "QUANTITY")
  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int v) {
    this.quantity = v;
  }
}
