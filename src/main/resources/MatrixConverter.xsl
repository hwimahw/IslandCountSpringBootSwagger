<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" encoding="utf-8" />
    <xsl:template match="/">
        <Graph>
            <matrix>
                <xsl:text>####</xsl:text>
            </matrix>
            <quantityOfRows>
                <xsl:param name="a" select="Matrix/quantityOfRows"></xsl:param>
                <xsl:param name="b" select="Matrix/quantityOfColumns"></xsl:param>
                <xsl:value-of select="$a * $b"></xsl:value-of>
            </quantityOfRows>
            <quantityOfColumns>
                <xsl:variable name="a" select="Matrix/quantityOfRows"></xsl:variable>
                <xsl:variable name="b" select="Matrix/quantityOfColumns"></xsl:variable>
                <xsl:value-of select="$a * $b"></xsl:value-of>
            </quantityOfColumns>
        </Graph>
    </xsl:template>
</xsl:stylesheet>