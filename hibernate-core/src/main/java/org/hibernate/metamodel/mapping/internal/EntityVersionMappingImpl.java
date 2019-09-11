/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.metamodel.mapping.internal;

import org.hibernate.engine.FetchStrategy;
import org.hibernate.metamodel.mapping.EntityVersionMapping;
import org.hibernate.metamodel.mapping.ManagedMappingType;
import org.hibernate.metamodel.mapping.StateArrayContributorMetadataAccess;
import org.hibernate.type.BasicType;

/**
 * @author Steve Ebersole
 */
public class EntityVersionMappingImpl extends BasicValuedSingularAttributeMapping implements EntityVersionMapping {
	public EntityVersionMappingImpl(
			String attributeName,
			int stateArrayPosition,
			StateArrayContributorMetadataAccess attributeMetadataAccess,
			String containingTableExpression,
			String mappedColumnExpression,
			BasicType basicType,
			ManagedMappingType declaringType) {
		super(
				attributeName,
				stateArrayPosition,
				attributeMetadataAccess,
				FetchStrategy.IMMEDIATE_JOIN,
				containingTableExpression,
				mappedColumnExpression,
				null,
				basicType,
				basicType,
				declaringType
		);
	}
}
