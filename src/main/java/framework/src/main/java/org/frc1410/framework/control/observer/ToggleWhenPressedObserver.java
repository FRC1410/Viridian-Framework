package framework.src.main.java.org.frc1410.framework.control.observer;

import framework.src.main.java.org.frc1410.framework.control.Button;
import framework.src.main.java.org.frc1410.framework.scheduler.task.LifecycleHandle;
import framework.src.main.java.org.frc1410.framework.scheduler.task.Observer;
import org.jetbrains.annotations.NotNull;

public class ToggleWhenPressedObserver implements Observer {

	private final Button button;
	private boolean listening = false;

	public ToggleWhenPressedObserver(Button button) {
		this.button = button;
	}

	@Override
	public void tick(@NotNull LifecycleHandle handle) {
		if (listening && button.isActive()) {
			listening = false;

			if (handle.state.isExecuting()) {
				handle.requestSuspension();
			} else {
				handle.requestExecution();
			}
		} else listening = true;
	}
}