/*
 * Copyright (c) 2008, 2018 Oracle and/or its affiliates. All rights reserved.
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

package com.sun.ts.tests.jpa.core.annotations.access.mappedsc;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;

/*
 * Project
 */

@Entity
@Access(AccessType.PROPERTY)
public class Project implements java.io.Serializable {

  // Instance Variables
  private long projId;

  private String name;

  private BigDecimal budget;

  public Project() {
  }

  public Project(long projId, String name, BigDecimal budget) {
    this.projId = projId;
    this.name = name;
    this.budget = budget;
  }

  // ===========================================================
  // getters and setters for the state fields

  @Id
  public long getProjId() {
    return projId;
  }

  public void setProjId(long projId) {
    this.projId = projId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getBudget() {
    return budget;
  }

  public void setBudget(BigDecimal budget) {
    this.budget = budget;
  }

}
