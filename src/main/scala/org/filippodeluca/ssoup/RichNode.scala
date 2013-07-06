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

import org.jsoup.nodes.Node
import collection.JavaConverters._

class RichNode(node: Node) {

  def siblingNodes: Iterable[Node] = node.siblingNodes.asScala

  def nextSiblingOpt: Option[Node] = Option(node.nextSibling)

  def previousSibling: Option[Node] = Option(node.previousSibling)

  def attrOpt(name: String): Option[String] = node.attr(name) match {
    case "" => None
    case x => Some(x)
  }

  def apply(name: String): String = attrOpt(name).get

}
