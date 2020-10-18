<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <h2>Exams</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th style="text-align:left">ExamID</th>
      <th style="text-align:left">ExamName</th>
      <th style="text-align:left">Description</th>
      <th style="text-align:left">Totalmarks</th>
    </tr>
    <xsl:for-each select="Exams/Exam">
    <tr>
      <td><xsl:value-of select="ExamID"/></td>
      <td><xsl:value-of select="ExamName"/></td>
      <td><xsl:value-of select="Description"/></td>
      <td><xsl:value-of select="Totalmarks"/></td>
    </tr>
    </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>

