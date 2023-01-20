/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html.
 */
package org.hibernate.sql.ast.internal;

import java.util.Map;

import org.hibernate.boot.registry.StandardServiceInitiator;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.hibernate.sql.ast.spi.JdbcParameterRenderer;

/**
 * @author Steve Ebersole
 */
public class JdbcParameterRendererInitiator implements StandardServiceInitiator<JdbcParameterRenderer> {
	/**
	 * Singleton access
	 */
	public static final JdbcParameterRendererInitiator INSTANCE = new JdbcParameterRendererInitiator();

	@Override
	public JdbcParameterRenderer initiateService(Map<String, Object> configurationValues, ServiceRegistryImplementor registry) {
		final boolean useNativeMarkers = ConfigurationHelper.getBoolean(
				AvailableSettings.DIALECT_NATIVE_PARAM_MARKERS,
				configurationValues,
				true
		);

		if ( useNativeMarkers ) {
			final Dialect dialect = registry.getService( JdbcServices.class ).getDialect();
			return dialect.getNativeParameterRenderer();
		}

		return JdbcParameterRendererStandard.INSTANCE;
	}

	@Override
	public Class<JdbcParameterRenderer> getServiceInitiated() {
		return JdbcParameterRenderer.class;
	}
}