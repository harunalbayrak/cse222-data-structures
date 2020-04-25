/**
 * The Product class
 */
public class Product {
    /**
     * The Information.
     */
    protected String information;
    /**
     * The Tracking number.
     */
    protected String trackingNum;
    /**
     * The name and surname of the sender.
     */
    protected String senderNameSurname;
    /**
     * The name and surname of the receiver.
     */
    protected String receiverNameSurname;
    /**
     * Keeps whether it has been delivered.
     */
    protected boolean isDelivered;

    /**
     * Instantiates a new Product.
     *
     * @param inf the information
     * @param trN the tracking number
     * @param sNS the name and surname of the sender
     * @param rNS the name and surname of the receiver
     */
    public Product(String inf,String trN,String sNS,String rNS){
        information = inf;
        trackingNum = trN;
        senderNameSurname = sNS;
        receiverNameSurname = rNS;
        isDelivered = false;
    }

    /**
     * Remove information.
     */
    public void removeInformation(){
        information = " ";
    }

    /**
     * Make delivered.
     */
    public void makeDelivered(){
        isDelivered = true;
        information = "It was delivered.";
    }

    @Override
    public String toString(){
        String all = "";
        all += "Name,Surname of Sender : " + senderNameSurname + "\n" + "Name,Surname of Receiver : " + receiverNameSurname
                + "\n" + "Current Status : " + information + "\n";
        return all;
    }
}
