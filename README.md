# Universal LTI 2.0 Tool Provider

Universal LTI 2.0 Tool provider helps any tool to become LTI compliant. Tool admin share their details with UTP (Universal Tool Provider). UTP provides tool proxy registration URL. Any LTI Tool consumer can use that url to register the tool. 

This is based on [IMS LTI v2.0 Standard](https://www.imsglobal.org/specs/ltiv2p0) specifications.

### What is LTI

  * The ability for a user within a VLE (or other web-based system) to seamlessly access a separate learning application, an item of protected content, or other restricted resource.
  
  * LTI has its origins in the IMS Tools Interoperability specifications released in 2006. 
  * LTI is essentially provided a means of connecting two systems together: a “Tool Consumer” which “consumes” the tool, and a “Tool Provider” which “provides” the Tool to be used in the Tool Consumer.  A Tool Consumer would typically be an LMS.
  
  **When a user is passed from the VLE to a tool, the following data may be carried with them :**

  * details about them (including name and email address).
  * details about the institutional context (such as the VLE being used).
  
  * details of the specific context from which they are coming (such as an online course).
  
  * their role within that context (such as “teacher” or “learner”).  
  
  >This “launch” process occurs in a secure manner (using OAuth)via the user’s web browser.

  **A connection between the twosystems is created by simply entering the following details inthe VLE:**
  
  * the URL to the other system.
  * a value to identify the customer (known as the “consumer key”).
  
  * a shared secret to secure the connection. 
