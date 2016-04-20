/* Copyright 2016 Google Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gapi.vgen;

import com.google.api.tools.framework.model.Interface;
import com.google.api.tools.framework.model.Method;
import com.google.api.tools.framework.model.Model;
import com.google.api.tools.framework.model.ProtoFile;
import com.google.common.collect.Multimap;

import java.io.IOException;

/**
 * A LanguageProvider performs code or fragment generation using on a proto-based
 * Model for a particular language.
 *
 * NOTE: The name is more general that its use case - it currently excludes
 * discovery-based use cases.
 */
public interface LanguageProvider {

  Model getModel();

  /**
   * Generates the code for the given interface using the given snippet.
   */
  GeneratedResult generateCode(Interface iface,
      SnippetDescriptor snippetDescriptor);

  /**
   * Generates the doc for the given proto file and snippet.
   */
  GeneratedResult generateDoc(ProtoFile file, SnippetDescriptor descriptor);

  /**
   * Generates a fragment for the given method.
   */
  GeneratedResult generateFragments(Method method,
      SnippetDescriptor snippetDescriptor);

  /**
   * Outputs the given elements to the given output path.
   */
  <Element> void output(String outputPath,
      Multimap<Element, GeneratedResult> elements, boolean archive)
          throws IOException;

}
