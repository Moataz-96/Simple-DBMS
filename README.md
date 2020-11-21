# DBMS && JDBC

Part1 - Simple DBMS 

Objectives

- Design an object oriented XML-based DBMS
- Getting familiar with XML parsers
- Draw a UML class diagram that represents your model
- Apply different design patterns to your model

Description:

A Computer Database is a structured collection of records or data that is stored in
a computer system. On the other hand, a Database Management System (DBMS)
is a complex set of software programs that controls the organization, storage,
management, and retrieval of data in a database. DBMS are categorized
according to their data structures or types. The DBMS accepts requests for data
from the application program and instructs the operating system to transfer the
appropriate data.
Extensible Markup Language (XML) is a set of rules for encoding documents in
machine readable form. It is defined in the XML 1.0 Specification produced by the
W3C, and several other related specifications, all gratis open standards. 

Tasks:

1. Implement a simple DBMS that handles data and store it in XML files. The DBMS
you will develop should control the management and retrieval of data from data
files. The DBMS accepts requests for data from application programs and
retrieves and transfers the appropriate data from files that are stored physically
on disk.

2. Each XML file will represent a Database Table. A database table is a set of data
elements (values) using a model of vertical columns (identifiable by name) and
horizontal rows, the cell being the unit where a row and column intersect. A table
has a specified number of columns, but can have any number of rows. 
Schema files contain data about the tables and columns that should exist. Tables
should be validated across their schema files (XML DTDs can be used for this
purpose). This means each table will have at least two files: one for data (XML
file), and one for its structure (DTD file)
You should use either SAX or DOM, or StAX parsers to parse and validate the XML
database files. However, there is only one of them is the best fit in this project, so
you should justify your choice in the report. (Hint: table file may be large file that
should not be fully loaded in memory)
For more information about XML parsing in Java please check this tutorial
https://docs.oracle.com/cd/B12037_01/appdev.101/b10794/adx04paj.htm

3. The users that will use your simple DBMS will use a language named Structured
Query Language (SQL) to send their commands to it. SQL is case insensitive. You
can find detailed statements descriptions at: http://www.w3schools.com/sql,
however, in this project you will not implement all commands of SQL, but will
support small subset of it. 
Your DBMS will support only two types: varchar and int. “varchar” used to store
string, and “int” to store numeric values (no floating point will be supported). Do
not support custom type lengths (e.g. varchar(255), or int(11) ), just assume all
types of the same default length.
For statements which contain conditions, support only the simple conditions: =,
>, and <. You are NOT required to support multiple or composite conditions that
use: AND, OR, or NOT.

4. The DBMS should NOT handle SQL queries directly. DBMS delegates this to
another class, say Parser class. The Parser receives the queries, validates them,
parses them, and then calls the appropriate action or reject the bad (invalid)
queries. The files should be created, updated or deleted, whenever any DBMS
function is called. 

--------------------------------------------------------------------------

Part2 - JDBC API 

Objectives

Upon completion of this assignment, you will be able to:
- Implements JDBC standard interface
- Integrate JDBC interface with your earlier DBMS implementation
- Apply different design patterns to your model

Description:

Remember in Part 1 of the project, you were asked to write a program that uses
your DBMS. Your program can work with any other DBMS that preserve the same
interface defined at Part 1. However, it would be great if your program can use
any DBMS including MySQL, Oracle, SQLServer, … etc.
In order to achieve that, Java defined another interface (larger than the one
defined in part 1), and asked the DBMS vendors such as MySQL, Oracle,
SQLServer, …. etc. to provide an implementation for this interface, so all Java
developers can change the DBMS easily without rewriting different Java
programs whenever they need to change the DBMS. This interface named JDBC
Java Database Connectivity (JDBC) provides Java developers with a standard API
that is used to access databases, regardless of the driver and database product.
JDBC presents a uniform interface to databases - change vendors and your
applications only need to change their JDBC driver. A typical program that uses
JDBC driver looks like the ones at the following link.
http://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html

Tasks:
- The JDBC defines five interfaces. You will implement a subset of the JDBC four
interfaces and leave other interface methods empty (or better to through a
runtime exception java.lang.UnsupportedOperationException) 

