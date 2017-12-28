package net.anotheria.moskito.core.config.dashboards;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.configureme.annotations.Configure;
import org.configureme.annotations.ConfigureMe;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Configuration of a single Dashboard.
 *
 * @author lrosenberg
 * @since 12.02.15 00:58
 */
@ConfigureMe
@SuppressFBWarnings(value = {"EI_EXPOSE_REP2", "EI_EXPOSE_REP"}, justification = "This is the way configureme works, it provides beans for access")
public class DashboardConfig implements Serializable{
	/**
	 * SerialVersionUID.
	 */
	private static final long serialVersionUID = 5472953727159931087L;

	/**
	 * Name of the dashboard.
	 */
	@Configure
	private String name;

	/**
	 * Dashboard refresh rate.
	 * In seconds.
	 * Default value: 60 seconds.
	 */
	private int refresh = 60;

	/**
	 * Charts to be shown on this dashboard.
	 */
	@Configure
	private ChartConfig [] charts;

	/**
	 * Names of the thresholds that should be on that dashboard.
	 */
	@Configure
	private String [] thresholds;

	/**
	 * Names of the gauges that should be on that dashboard.
	 */
	@Configure
	private String [] gauges;

	/**
	 * Producer names that should be present on dashboard.
	 */
	@Configure
	private String[] producers;

	/**
	 * Widgets that should be present on dashboard.
	 * Order in array determines display order on dashboard.
	 */
	@Configure
	private String[] widgets = new String[] {
			DashboardWidget.THRESHOLDS.getName(), DashboardWidget.GAUGES.getName(),
			DashboardWidget.CHARTS.getName(), DashboardWidget.PRODUCERS.getName()
	};


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("DashboardConfig{");
		sb.append("name='").append(name).append('\'');
		sb.append(", refresh=").append(refresh);
		sb.append(", charts=").append(Arrays.toString(charts));
		sb.append(", thresholds=").append(Arrays.toString(thresholds));
		sb.append(", gauges=").append(Arrays.toString(gauges));
		sb.append(", producers=").append(Arrays.toString(producers));
		sb.append(", widgets=").append(Arrays.toString(widgets));
		sb.append('}');
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRefresh() {
		return refresh;
	}

	public void setRefresh(int refresh) {
		this.refresh = refresh;
	}

	public String[] getThresholds() {
		return thresholds;
	}

	public void setThresholds(String[] thresholds) {
		this.thresholds = thresholds;
	}

	public ChartConfig[] getCharts() {
		return charts;
	}

	public void setCharts(ChartConfig[] charts) {
		this.charts = charts;
	}

	public String[] getGauges() {
		return gauges;
	}

	public void setGauges(String[] gauges) {
		this.gauges = gauges;
	}

	public String[] getProducers() {
		return producers;
	}

	public void setProducers(String[] producers) {
		this.producers = producers;
	}

	public String[] getWidgets() {
		return widgets;
	}

	public void setWidgets(String[] widgets) {
		this.widgets = widgets;
	}
}
