/**
 * 
 */
package com.aska.store.entity;

import java.util.Date;

/**
 * @author ppalpandi
 *
 */
public class RequestEntity {
	
	private Long requestId;
	private Long userId;
	private Long storeId;
	private String firstName;
	private String lastName;
	private String email;
	private String rejectionNote;
	private int status;
	private Date requestDate;
	private Date lastUpdatedDate;
	
}
