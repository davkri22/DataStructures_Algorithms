package Unit8.Vehicle;

public class TestFordFrivolous3_SelfDriving extends BCATestScenario {

	@Override
	public int runTest() {
		FordFrivolous f3 = new FordFrivolous();
		assertThrows(IllegalArgumentException.class, () -> f3.driveAutonomously(-1), "Negative miles cannot be drove.");
		f3.driveAutonomously(118);
		assertEquals(f3.getFuelLevel(), 10.0, DELTA, "Half of fuel tank should be exhausted.");
		f3.driveAutonomously(472);
		assertEquals(f3.getFuelLevel(), 0, DELTA, "Fuel level should be 0.");
		assertEquals(f3.getMileage(), 236, DELTA, "Mileage should be 236.");
		return getFailedCount();
	}
}
