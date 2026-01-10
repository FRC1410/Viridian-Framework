package framework.src.main.java.org.frc1410.framework.control;

import edu.wpi.first.wpilibj2.command.Command;
import framework.src.main.java.org.frc1410.framework.control.observer.WhenPressedObserver;
import framework.src.main.java.org.frc1410.framework.control.observer.WhileHeldObserver;
import framework.src.main.java.org.frc1410.framework.control.observer.WhileHeldOnceObserver;
import framework.src.main.java.org.frc1410.framework.scheduler.task.Task;
import framework.src.main.java.org.frc1410.framework.scheduler.task.TaskPersistence;
import framework.src.main.java.org.frc1410.framework.scheduler.task.TaskScheduler;
import framework.src.main.java.org.frc1410.framework.scheduler.task.impl.CommandTask;
import framework.src.main.java.org.frc1410.framework.scheduler.task.lock.LockPriority;
import org.intellij.lang.annotations.MagicConstant;

public interface Button {

	TaskScheduler scheduler();

	boolean isActive();

	default void whenPressed(Task task, TaskPersistence persistence) {
		scheduler().schedule(task, persistence, new WhenPressedObserver(this), LockPriority.HIGH);
	}

	default void whenPressed(Command command, TaskPersistence persistence) {
		whenPressed(new CommandTask(command), persistence);
	}

	default void whileHeld(Task task, TaskPersistence persistence) {
		scheduler().schedule(task, persistence, new WhileHeldObserver(this), LockPriority.HIGH);
	}

	default void whileHeld(Command command, TaskPersistence persistence) {
		whileHeld(new CommandTask(command), persistence);
	}

	default void whileHeldOnce(Task task, TaskPersistence persistence) {
		scheduler().schedule(task, persistence, new WhileHeldOnceObserver(this), LockPriority.HIGH);
	}

	default void whileHeldOnce(Command command, TaskPersistence persistence) {
		whileHeldOnce(new CommandTask(command), persistence);
	}

	default void whileHeldOnce(Command command, TaskPersistence persistence, @MagicConstant(valuesFromClass = LockPriority.class) int lockPriority) {
		scheduler().schedule(new CommandTask(command), persistence, new WhileHeldOnceObserver(this), lockPriority);
	}

	default void toggleWhenPressed(Task task, TaskPersistence persistence) {
		scheduler().schedule(task, persistence, new WhenPressedObserver(this), LockPriority.HIGH);
	}

	default void toggleWhenPressed(Command command, TaskPersistence persistence) {
		toggleWhenPressed(new CommandTask(command), persistence);
	}
}