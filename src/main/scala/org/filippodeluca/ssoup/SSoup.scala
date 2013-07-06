/*
 * Copyright 2013 Filippo De Luca - me@filippodeluca.com
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.filippodeluca.ssoup

import org.jsoup.select.Elements
import org.jsoup.nodes._
import org.jsoup.Jsoup
import java.net.URL
import scala.concurrent.duration.Duration
import collection.JavaConverters._
import java.io.{File, InputStream}
import org.jsoup.parser.Parser

/**
 * The entry point of the Pimp-my-library pattern.
 */
object SSoup {

  def parse(url: URL, duration: Duration) = Jsoup.parse(url, duration.toMillis.toInt)

  def parse(body: String) = Jsoup.parse(body)

  def parse(body: String, baseUri: String) = Jsoup.parse(body, baseUri)

  def parse(body: String, baseUri: String, parser: Parser) = Jsoup.parse(body, baseUri, parser)

  def parse(in: InputStream, charsetName: String, baseUri: String, parser: Parser) = {
    Jsoup.parse(in, charsetName, baseUri, parser)
  }

  def parse(in: InputStream, charsetName: String, baseUri: String) = {
    Jsoup.parse(in, charsetName, baseUri)
  }

  def parse(in: File, charsetName: String, baseUri: String) = {
    Jsoup.parse(in, charsetName, baseUri)
  }

  def parse(in: File, charsetName: String) = {
    Jsoup.parse(in, charsetName)
  }

  def parseBodyFragment(body: String) = Jsoup.parseBodyFragment(body)

  def parseBodyFragment(body: String, baseUri: String) = Jsoup.parseBodyFragment(body, baseUri)

  implicit def enrichNode(n: Node) = new RichNode(n)

  implicit def listNode2IterableNode(xs: java.util.List[Node]): Iterable[Node] = xs.asScala

  implicit def listTextNode2IterableTextNode(xs: java.util.List[TextNode]): Iterable[TextNode] = xs.asScala

  implicit def listDataNode2IterableDataNode(xs: java.util.List[DataNode]): Iterable[DataNode] = xs.asScala

  implicit def enrichElement(x: Element) = new RichElement(x)

  implicit def enrichDocument(x: Document) = new RichDocument(x)

  implicit def enrichElements(xs: Elements) = new RichElements(xs)

}
