public class Client {
    private int clientId;
    private String clientName;
    private String contactInformation;
    private String billingAddress;
    private double totalAmountBilled;

    public Client(int clientId, String clientName, String contactInformation, String billingAddress, double totalAmountBilled) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.contactInformation = contactInformation;
        this.billingAddress = billingAddress;
        this.totalAmountBilled = totalAmountBilled;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public double getTotalAmountBilled() {
        return totalAmountBilled;
    }

    public void setTotalAmountBilled(double totalAmountBilled) {
        this.totalAmountBilled = totalAmountBilled;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", contactInformation='" + contactInformation + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", totalAmountBilled=" + totalAmountBilled +
                '}';
    }
}
