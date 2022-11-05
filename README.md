 Sources: https://www.tutorialspoint.com/jpa/jpa_quick_guide.htm 
- If you set exclude-unlisted-classes to true, you also have to list the entities within class elements in your persistence.xml . Example: 
  +   <class>entity.Employee</class>
  +  <class>entity.Employees</class>
  +  <class>entity.FullTimeEmployee</class>
  +  <class>entity.PartTimeEmployee</class> 
- If you set exclude-unlisted-classes to false the persistence layer can find the entities regardles of the class element in your persistence.xml.
  + <exclude-unlisted-classes>false</exclude-unlisted-classes>

* @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
+ create a table with all column within 
+ Single-Table strategy takes all classes fields (both super and sub classes) and map them down into a single table known as SINGLE_TABLE strategy. Here discriminator value plays key role in differentiating the values of three entities in one table.
* @Inheritance(strategy = InheritanceType.JOINED)
+ create a equivalent number table 
+ Joined table strategy is to share the referenced column which contains unique values to join the table and make easy transactions.