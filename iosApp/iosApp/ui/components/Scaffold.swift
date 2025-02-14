
import SwiftUI

struct Scaffold<TopBar, Content, BottomBar, Background>: View
  where TopBar: View, Content: View, BottomBar: View, Background: View {
  enum Layout {
    case stacked, floatingTopBar

    @ViewBuilder
    func apply(to scaffold: Scaffold, metrics: GeometryProxy) -> some View {
      switch self {
      case .stacked:
        VStack(spacing: 0) {
          scaffold.topBar(metrics)
          scaffold.content(metrics)
          Spacer(minLength: 0)
          scaffold.bottomBar(metrics)
        }
      case .floatingTopBar:
        ZStack(alignment: .top) {
          VStack(spacing: 0) {
            scaffold.content(metrics)
            Spacer(minLength: 0)
            scaffold.bottomBar(metrics)
          }
          scaffold.topBar(metrics)
        }
      }
    }
  }

  let layout: Layout
  @ViewBuilder let topBar: (GeometryProxy) -> TopBar
  @ViewBuilder let bottomBar: (GeometryProxy) -> BottomBar
  let containerColor: Color?
  let contentColor: Color?
  let background: Background?
  @ViewBuilder let content: (GeometryProxy) -> Content

  init(
    layout: Layout = .stacked,
    @ViewBuilder topBar: @escaping (GeometryProxy) -> TopBar,
    @ViewBuilder bottomBar: @escaping (GeometryProxy) -> BottomBar,
    containerColor: Color? = nil,
    contentColor: Color? = nil,
    background: Background? = nil,
    @ViewBuilder content: @escaping (GeometryProxy) -> Content
  ) {
    self.layout = layout
    self.topBar = topBar
    self.bottomBar = bottomBar
    self.containerColor = containerColor
    self.contentColor = contentColor
    self.background = background
    self.content = content
  }

  init(
    layout: Layout = .stacked,
    topBar: TopBar,
    bottomBar: BottomBar,
    containerColor: Color? = nil,
    contentColor: Color? = nil,
    background: Background? = nil,
    @ViewBuilder content: @escaping (GeometryProxy) -> Content
  ) {
    self.layout = layout
    self.topBar = { _ in topBar }
    self.bottomBar = { _ in bottomBar }
    self.containerColor = containerColor
    self.contentColor = contentColor
    self.background = background
    self.content = content
  }

  var body: some View {
    GeometryReader { metrics in
      Surface(color: containerColor, contentColor: contentColor) {
        background

        layout.apply(to: self, metrics: metrics)
          .edgesIgnoringSafeArea(.vertical)
      }
    }
  }
}

extension Scaffold where TopBar == EmptyView, BottomBar == EmptyView {
  init(
    layout: Layout = .stacked,
    containerColor: Color? = nil,
    contentColor: Color? = nil,
    background: Background? = nil,
    @ViewBuilder content: @escaping (GeometryProxy) -> Content
  ) {
    self.init(
      layout: layout,
      topBar: { _ in },
      bottomBar: { _ in },
      containerColor: containerColor,
      contentColor: contentColor,
      background: background,
      content: content
    )
  }
}

extension Scaffold where BottomBar == EmptyView {
  init(
    layout: Layout = .stacked,
    @ViewBuilder topBar: @escaping (GeometryProxy) -> TopBar,
    containerColor: Color? = nil,
    contentColor: Color? = nil,
    background: Background? = nil,
    @ViewBuilder content: @escaping (GeometryProxy) -> Content
  ) {
    self.init(
      layout: layout,
      topBar: topBar,
      bottomBar: { _ in },
      containerColor: containerColor,
      contentColor: contentColor,
      background: background,
      content: content
    )
  }

  init(
    layout: Layout = .stacked,
    topBar: TopBar,
    containerColor: Color? = nil,
    contentColor: Color? = nil,
    background: Background? = nil,
    @ViewBuilder content: @escaping (GeometryProxy) -> Content
  ) {
    self.init(
      layout: layout,
      topBar: { _ in topBar },
      bottomBar: { _ in },
      containerColor: containerColor,
      contentColor: contentColor,
      background: background,
      content: content
    )
  }
}

extension Scaffold where TopBar == EmptyView {
  init(
    layout: Layout = .stacked,
    @ViewBuilder bottomBar: @escaping (GeometryProxy) -> BottomBar,
    containerColor: Color? = nil,
    contentColor: Color? = nil,
    background: Background? = nil,
    @ViewBuilder content: @escaping (GeometryProxy) -> Content
  ) {
    self.init(
      layout: layout,
      topBar: { _ in },
      bottomBar: bottomBar,
      containerColor: containerColor,
      contentColor: contentColor,
      background: background,
      content: content
    )
  }

  init(
    layout: Layout = .stacked,
    bottomBar: BottomBar,
    containerColor: Color? = nil,
    contentColor: Color? = nil,
    background: Background? = nil,
    @ViewBuilder content: @escaping (GeometryProxy) -> Content
  ) {
    self.init(
      layout: layout,
      topBar: { _ in },
      bottomBar: { _ in bottomBar },
      containerColor: containerColor,
      contentColor: contentColor,
      background: background,
      content: content
    )
  }
}

extension Scaffold where BottomBar == EmptyView, Background == EmptyView {
  init(
    layout: Layout = .stacked,
    @ViewBuilder topBar: @escaping (GeometryProxy) -> TopBar,
    containerColor: Color? = nil,
    contentColor: Color? = nil,
    @ViewBuilder content: @escaping (GeometryProxy) -> Content
  ) {
    self.init(
      layout: layout,
      topBar: topBar,
      bottomBar: { _ in },
      containerColor: containerColor,
      contentColor: contentColor,
      background: nil,
      content: content
    )
  }

  init(
    layout: Layout = .stacked,
    topBar: TopBar,
    containerColor: Color? = nil,
    contentColor: Color? = nil,
    @ViewBuilder content: @escaping (GeometryProxy) -> Content
  ) {
    self.init(
      layout: layout,
      topBar: { _ in topBar },
      bottomBar: { _ in },
      containerColor: containerColor,
      contentColor: contentColor,
      background: nil,
      content: content
    )
  }
}

extension Scaffold where Background == EmptyView {
  init(
    layout: Layout = .stacked,
    @ViewBuilder topBar: @escaping (GeometryProxy) -> TopBar,
    @ViewBuilder bottomBar: @escaping (GeometryProxy) -> BottomBar,
    containerColor: Color? = nil,
    contentColor: Color? = nil,
    @ViewBuilder content: @escaping (GeometryProxy) -> Content
  ) {
    self.init(
      layout: layout,
      topBar: topBar,
      bottomBar: bottomBar,
      containerColor: containerColor,
      contentColor: contentColor,
      background: nil,
      content: content
    )
  }

  init(
    layout: Layout = .stacked,
    topBar: TopBar,
    bottomBar: BottomBar,
    containerColor: Color? = nil,
    contentColor: Color? = nil,
    @ViewBuilder content: @escaping (GeometryProxy) -> Content
  ) {
    self.init(
      layout: layout,
      topBar: { _ in topBar },
      bottomBar: { _ in bottomBar },
      containerColor: containerColor,
      contentColor: contentColor,
      background: nil,
      content: content
    )
  }
}

struct Scaffold_Previews: PreviewProvider {
  static var previews: some View {
    Scaffold(
      topBar: { _ in
      },
      bottomBar: { _ in
      },
      content: { _ in
        Button("Hello Scaffold!") {
        }
      }
    )
  }
}
