package com.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ContactController {
	
	//path parameter based Api Versioning
	
	@GetMapping(value="/api/contact/v1", produces= MediaType.APPLICATION_JSON_VALUE)
	public Contact getContact() {
		return new Contact("Tom", 1234);
	}

		@GetMapping(value="/api/contact/v2", produces= MediaType.APPLICATION_JSON_VALUE)
		public ContactV2 getContact2() {
			return new ContactV2("Tom", 1234);	
		}
	//Query/request based api versioning
		@GetMapping(value="/api/contact", produces= MediaType.APPLICATION_JSON_VALUE, params = "version=v1")
		public Contact getContactQueryV1() {
			return new Contact("Tom", 1234);
		}

			@GetMapping(value="/api/contact/v2", produces= MediaType.APPLICATION_JSON_VALUE, params = "version=v2")
			public ContactV2 getContactQueryV2() {
				return new ContactV2("Tom", 1234);	
			}
	//content negotiation based api versioning	
			@GetMapping(value="/api/contact", produces= "application/contact.v1+json")
			public Contact getContactContentNegoV1() {
				return new Contact("Tom", 1234);
			}

				@GetMapping(value="/api/contact", produces= "application/contact.v2+json")
				public ContactV2 getContactContentNegoV2() {
					return new ContactV2("Tom", 1234);	
				}
				
	//Header Parameter based			
				@GetMapping(value="/api/contact", produces= MediaType.APPLICATION_JSON_VALUE, headers = "version=v1")
				public Contact getContactHeaderV1() {
					return new Contact("Tom", 1234);
				}

					@GetMapping(value="/api/contact/v2", produces= MediaType.APPLICATION_JSON_VALUE, headers = "version=v2")
					public ContactV2 getContactHeaderV2() {
						return new ContactV2("Tom", 1234);	
					}	
	}
	
	class Contact{
		private String name;
		private int mobile;
		
		public Contact() {
			super();
		}
		public Contact(String name, int mobile) {
			super();
			this.name = name;
			this.mobile = mobile;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getMobile() {
			return mobile;
		}
		public void setMobile(int mobile) {
			this.mobile = mobile;
		}
		@Override
		public String toString() {
			return "Contact [name=" + name + ", mobile=" + mobile + "]";
		}
	}
		class ContactV2{
			private String name;
			private int mobileno;
			public ContactV2() {
				super();
			}
			public ContactV2(String name, int mobileno) {
				super();
				this.name = name;
				this.mobileno = mobileno;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getMobileno() {
				return mobileno;
			}
			public void setMobileno(int mobileno) {
				this.mobileno = mobileno;
			}
			@Override
			public String toString() {
				return "ContactV2 [name=" + name + ", mobileno=" + mobileno + "]";
			}
			
		}
		
	

