<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <h2>Courses</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th style="text-align:left">Course ID</th>
      <th style="text-align:left">Course Name</th>
    </tr>
    <xsl:for-each select="Courses/Course">
    <tr>
      <td><xsl:value-of select="CourseID"/></td>
      <td><xsl:value-of select="CourseName"/></td>
    </tr>
    </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>

