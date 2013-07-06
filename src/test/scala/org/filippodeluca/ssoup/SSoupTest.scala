package org.filippodeluca.ssoup

import org.specs2.mutable.Specification
import SSoup._
import org.jsoup.nodes.{Node, Element}

class SSoupTest extends Specification {

  val html =
    """
      |<html>
      |  <head>
      |  </head>
      |  <body>
      |    <div id="foo" class="bar>Hello World</div>
      |  </body>
      |</html>
    """.stripMargin


  "SSoup" should {
    "Return RichDocument" in {

      val doc: RichDocument = parse(html)

      doc must beAnInstanceOf[RichDocument]
    }
    "Return RichElement" in {

      val doc = parse(html)

      val head: RichElement = doc.head

      head must beAnInstanceOf[RichElement]
    }
    "Return RichElements" in {

      val doc = parse(html)

      val head = doc.head

      val xs: RichElements = head.getElementsByAttributeStarting("foo")

      xs must beAnInstanceOf[RichElements]
    }

  }

}
