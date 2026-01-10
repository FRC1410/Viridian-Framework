package framework.src.main.java.org.frc1410.framework.control.observer;

import framework.src.main.java.org.frc1410.framework.control.Button;
import framework.src.main.java.org.frc1410.framework.scheduler.task.LifecycleHandle;
import framework.src.main.java.org.frc1410.framework.scheduler.task.Observer;
import org.jetbrains.annotations.NotNull;

public class WhileHeldObserver implements Observer {

	private final Button button;

	public WhileHeldObserver(Button button) {
		this.button = button;
	}

	@Override
	public void tick(@NotNull LifecycleHandle handle) {
		if (button.isActive()) {
			handle.requestExecution();
		} else {
			handle.requestSuspension();
		}
	}
}