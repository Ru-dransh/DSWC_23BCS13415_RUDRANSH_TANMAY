public abstract class SpaceVessel {
    protected short shipId;           
    protected boolean isOperational;  
    protected char fleetClass;        

    public SpaceVessel(short shipId, boolean isOperational, char fleetClass) {
        this.shipId = shipId;
        this.isOperational = isOperational;
        this.fleetClass = fleetClass;
    }
}