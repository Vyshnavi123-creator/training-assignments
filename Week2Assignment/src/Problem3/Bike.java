package Problem3;

public interface Bike {
      final int speedLimit=90;
      default int getBikeSpeed() {
    	  return speedLimit;
      }
      void detailsOfBike();
}
