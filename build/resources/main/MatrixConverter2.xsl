<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <Graph>
            <matrix>
                <quantityOfRows>
                    <xsl:call-template name="template"></xsl:call-template>
                </quantityOfRows>
                <quantityOfColumns>
                    <xsl:call-template name="template"></xsl:call-template>
                </quantityOfColumns>
            </matrix>
        </Graph>


    </xsl:template>

    <xsl:template name="template">
        <xsl:param name="a" select="Matrix/quantityOfRows"></xsl:param>
        <xsl:param name="b" select="Matrix/quantityOfColumns"></xsl:param>
        <xsl:value-of select="$a * $b"></xsl:value-of>
    </xsl:template>


</xsl:stylesheet>