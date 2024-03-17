public class Service {
    private int serviceId;
    private String serviceName;
    private double hourlyRate;

    public Service(int serviceId, String serviceName, double hourlyRate) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.hourlyRate = hourlyRate;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}
