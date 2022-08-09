package ru.itm.bkdb.entity.tables.status;

import ru.itm.bkdb.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "status_inh", schema = "status")
public final class StatusInheritance extends AbstractEntity {
	private Long cur_st_id;
	private Long nxt_st_id;
	private boolean excluded;

	@Override
	public String toString() {
		return "status.status_inh{" +
				"id=" + id +
				", cur_st_id=" + cur_st_id +
				", nxt_st_id=" + nxt_st_id +
				", excluded=" + excluded +
				'}';
	}
	@Override
	public String toStringShow() {
		return this.toString();
	}

	public StatusInheritance() {
	}

	public Long getCur_st_id() {
		return cur_st_id;
	}

	public void setCur_st_id(Long cur_st_id) {
		this.cur_st_id = cur_st_id;
	}

	public Long getNxt_st_id() {
		return nxt_st_id;
	}

	public void setNxt_st_id(Long nxt_st_id) {
		this.nxt_st_id = nxt_st_id;
	}

	public boolean isExcluded() {
		return excluded;
	}

	public void setExcluded(boolean excluded) {
		this.excluded = excluded;
	}
}
