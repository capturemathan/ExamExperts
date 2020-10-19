<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <h2>Countries</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th style="text-align:left">email</th>
      <th style="text-align:left">pass</th>
      <th style="text-align:left">name</th>
    </tr>
    <xsl:for-each select="users/user">
    <tr>
      <td><xsl:value-of select="email"/></td>
      <td><xsl:value-of select="pass"/></td>
      <td><xsl:value-of select="name"/></td>
    </tr>
    </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>

