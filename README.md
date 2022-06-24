# Authentication Service Microservice

This Microservice will be responsible for providing below functionalities to the consumer:
<br>
<ol>
  <li>Registration of new user</li>
  <li>User confirmation (User confirmation email will be sent to user registerd email id)</li>
  <li>Handling of Invalid login attempts and account lock/unlock feature</li>
  <li>User Login</li>
  <li>User profile update</li>
  <li>Consuming services can request for user logs.</li>
</ol>
<br>

#### User Table Design - It will be executed using Flyway scripts.
<table>
   <thead>
      <tr>
         <th>USER_ID</th>
         <th>USER_NAME</th>
         <th>PASSWORD</th>
         <th>ACTIVE</th>
         <th>CONFIRMED</th>
         <th>INVALID_LOGIN_ATTEMPTS</th>
         <th>LOCKED</th>
         <th>LAST_ACCESS</th>
         <th>USER_PROFILE_ID</th>
         <th>R_CRE_TIME</th>
         <th>R_MOD_TIME</th>
      </tr>
   </thead>
   <tbody>
      <tr>
         <td>User id of the user</td>
         <td>username of the user</td>
         <td>password provided by the user which will in encrypted form</td>
          <td>UserId is active or not</td>
         <td>First time user will have to provide the confirmation by clicking the link sent in the email</td>
         <td>Number of invalid login attempts</td>
          <td>After given invalid login attempts account will b locked</td>
         <td>Last access time</td>
         <td>User profile Id which will have other user related information</td>
         <td>Record creation time</td>
          <td>Record modification time</td>
      </tr>
   </tbody>
</table>
