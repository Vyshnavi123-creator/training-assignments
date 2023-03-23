package Problem3;

public class Pulsar implements Bike {
	String bikeName="Pulsar";
	@Override
	public void detailsOfBike() {
		
		// TODO Auto-generated method stub
		System.out.println("Bike name is "+bikeName+" and the speed limit is "+getBikeSpeed()+"KMPH");
	}

}
