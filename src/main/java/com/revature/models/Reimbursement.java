package com.revature.models;

//import java.sql.String;
//import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ers_reimbursement")
public class Reimbursement {
	
	//Create fields/variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reimb_id")
	private int id;
	
	@Column(name = "reimb_amount")
	private int amount;
	
	@Column(name = "reimb_submitted")
	private String submitted;
	
	@Column(name = "reimb_resolved")
	private String resolved;
	
	@Column(name = "reimb_description")
	private String description;
	
	@Column(name = "reimb_receipt")
	private String receipt;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="reimb_author_id", referencedColumnName="users_id")
	private User author;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="reimb_resolver_id", referencedColumnName="users_id")
	private User resolver;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "reimb_status_id_fk", referencedColumnName="reimb_status_id")
	private Status status;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "reimb_type_id_fk",  referencedColumnName="reimb_type_id")
	private Type type;

	
	//boilerplate code below 
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reimbursement(int id, int amount, String submitted, String resolved, String description,
			String receipt, User author, User resolver, Status status, Type type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}


	public Reimbursement(int amount, String submitted, String resolved, String description, String receipt,
			User author, User resolver, Status status, Type type) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}


	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", receipt=" + receipt + ", author=" + author + ", resolver="
				+ resolver + ", status=" + status + ", type=" + type + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (amount != other.amount)
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		} else if (!receipt.equals(other.receipt))
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getSubmitted() {
		return submitted;
	}


	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}


	public String getResolved() {
		return resolved;
	}


	public void setResolved(String resolved) {
		this.resolved = resolved;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getReceipt() {
		return receipt;
	}


	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}


	public User getAuthor() {
		return author;
	}


	public void setAuthor(User author) {
		this.author = author;
	}


	public User getResolver() {
		return resolver;
	}


	public void setResolver(User resolver) {
		this.resolver = resolver;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}
	
	
	
	
	
	

}
