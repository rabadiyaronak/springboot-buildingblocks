package learn.restservices.config;

import org.springframework.context.annotation.Configuration;

import io.micrometer.appoptics.AppOpticsConfig;
import io.micrometer.appoptics.AppOpticsMeterRegistry;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.lang.Nullable;

@Configuration
public class MonitoringConfig {

	AppOpticsConfig appopticsConfig = new AppOpticsConfig() {
		@Override
		public String apiToken() {
			return "XW7Y3i3WcgF83LrksRT8Mgx5aD2GRQnezj8urx7GbGR9IZeICuv-0AvPSkl1dhRxDtV2RpY";
		}

		@Override
		@Nullable
		public String get(String k) {
			return null;
		}
	};
	MeterRegistry registry = new AppOpticsMeterRegistry(appopticsConfig, Clock.SYSTEM);
}
