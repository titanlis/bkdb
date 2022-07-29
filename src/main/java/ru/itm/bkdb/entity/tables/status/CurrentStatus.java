package ru.itm.bkdb.entity.tables.status;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.*;
import java.util.Calendar;

/**Косяки с серверной базой. Нет такой таблицы в базе.*/
//@Entity
//@Table(name = "status", schema = "current")
public class CurrentStatus extends AbstractEntity {
	@ManyToOne
	@JoinColumn(name="cur_stat_one")
	private Statuses currentStatusOne;
	
	@ManyToOne
	@JoinColumn(name="cur_stat_two")
	private Statuses currentStatusTwo;
	
	@ManyToOne
	@JoinColumn(name="cur_stat_three")
	private Statuses currentStatusThree;
	
	@ManyToOne
	@JoinColumn(name="prev1_stat_one")
	private Statuses prev1StatusOne;
	
	@ManyToOne
	@JoinColumn(name="prev1_stat_two")
	private Statuses prev1StatusTwo;
	
	@ManyToOne
	@JoinColumn(name="prev1_stat_three")
	private Statuses prev1StatusThree;
	
	@ManyToOne
	@JoinColumn(name="prev2_stat_one")
	private Statuses prev2StatusOne;
	
	@ManyToOne
	@JoinColumn(name="prev2_stat_two")
	private Statuses prev2StatusTwo;
	
	@ManyToOne
	@JoinColumn(name="prev2_stat_three")
	private Statuses prev2StatusThree;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "source_set")
	private SOURCE_SET sourceSet;
	
	@Column(name = "set_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar setTime;

	
	public Statuses getCurrentStatusOne() {
		return currentStatusOne;
	}

	public void setCurrentStatusOne(Statuses currentStatusOne) {
		prev2StatusOne = prev1StatusOne;
		prev1StatusOne = this.currentStatusOne;
		this.currentStatusOne = currentStatusOne;		
	}

	public Statuses getCurrentStatusTwo() {
		return currentStatusTwo;
	}

	public void setCurrentStatusTwo(Statuses currentStatusTwo) {
		prev2StatusTwo = prev1StatusTwo;
		prev1StatusTwo = this.currentStatusTwo;
		this.currentStatusTwo = currentStatusTwo;
	}

	public Statuses getCurrentStatusThree() {
		return currentStatusThree;
	}

	public void setCurrentStatusThree(Statuses currentStatusThree) {
		prev2StatusThree = prev1StatusThree;
		prev1StatusThree = this.currentStatusThree;
		this.currentStatusThree = currentStatusThree;
	}

	public Statuses getPrev1StatusOne() {
		return prev1StatusOne;
	}

	public Statuses getPrev1StatusTwo() {
		return prev1StatusTwo;
	}

	public Statuses getPrev1StatusThree() {
		return prev1StatusThree;
	}

	public Statuses getPrev2StatusOne() {
		return prev2StatusOne;
	}

	public Statuses getPrev2StatusTwo() {
		return prev2StatusTwo;
	}

	public Statuses getPrev2StatusThree() {
		return prev2StatusThree;
	}

	@Override
	public String toStringShow() {
		return null;
	}
}
