<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <h2>Bookmarks</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th style="text-align:left">Email</th>
      <th style="text-align:left">UniversityID</th>
      <th style="text-align:left">University</th>
      <th style="text-align:left">Description</th>
      <th style="text-align:left">URL</th>
      <th style="text-align:left">Location</th>
      <th style="text-align:left">Cutoff</th>
      <th style="text-align:left">ExamID</th>
      <th style="text-align:left">CountryID</th>
      <th style="text-align:left">CourseID</th>
    </tr>
    <xsl:for-each select="Bookmarks/Bookmark">
    <tr>
      <td><xsl:value-of select="Email"/></td>
      <td><xsl:value-of select="UniversityID"/></td>
      <td><xsl:value-of select="University"/></td>
      <td><xsl:value-of select="Description"/></td>
      <td><xsl:value-of select="URL"/></td>
      <td><xsl:value-of select="Location"/></td>
      <td><xsl:value-of select="Cutoff"/></td>
      <td><xsl:value-of select="ExamID"/></td>
      <td><xsl:value-of select="CountryID"/></td>
      <td><xsl:value-of select="CourseID"/></td>
    </tr>
    </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>

