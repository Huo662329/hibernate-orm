/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.testing.annotations;

import org.hibernate.dialect.H2Dialect;

import org.hibernate.testing.orm.junit.DomainModel;
import org.hibernate.testing.orm.junit.RequiresDialect;
import org.hibernate.testing.orm.junit.SessionFactory;
import org.hibernate.testing.orm.junit.SessionFactoryScope;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@RequiresDialect(H2Dialect.class)
@DomainModel( annotatedClasses = AnEntity.class )
@SessionFactory
public class BasicSessionFactoryScopeTests {
	@Test
	public void testBasicUsage(SessionFactoryScope scope) {
		assertThat( scope, notNullValue() );
		assertThat( scope.getSessionFactory(), notNullValue() );
		// check we can use the SF to create Sessions
		scope.inTransaction(
				session -> session.createQuery( "from AnEntity" ).list()
		);
	}

}
