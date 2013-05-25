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
import org.jsoup.nodes.{Node, Document, Element}

/**
 * The entry point of the Pimp-my-library pattern.
 */
object SSoup {

  implicit def enrichNode(n: Node) = new RichNode(n)

  implicit def enrichElement(x: Element) = new RichElement(x)

  implicit def enrichDocument(x: Document) = new RichDocument(x)

  implicit def enrichElements(xs: Elements) = new RichElements(xs)

}
